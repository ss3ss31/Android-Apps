package com.example.socialapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et_Name,et_LastName,et_Phone,et_Designation;
    Button btn_register;
    ImageView add_from_gallry;
    TextView tv_from_gallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Hide toolbar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // initilize
        et_Name         =       (EditText) findViewById(R.id.et_r_first_name);
        et_LastName     =       (EditText) findViewById(R.id.et_r_last_name);
        et_Phone        =       (EditText) findViewById(R.id.et_r_phone);
        et_Designation  =       (EditText) findViewById(R.id.et_r_designation);
        btn_register    =       (Button) findViewById(R.id.btn_register);
        add_from_gallry =       (ImageView) findViewById(R.id.iv_add_from_gellery);
        tv_from_gallery =       (TextView) findViewById(R.id.tv_add_from_gallery);

        // onclick listener
        et_Name.setOnClickListener(this);
        et_LastName.setOnClickListener(this);
        et_Phone.setOnClickListener(this);
        et_Designation.setOnClickListener(this);
        btn_register.setOnClickListener(this);
        add_from_gallry.setOnClickListener(this);
        tv_from_gallery.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.et_r_first_name:

                break;
            case R.id.et_r_last_name:

                break;
            case R.id.et_r_phone:

                break;
            case R.id.et_r_designation:

                break;
            case R.id.iv_add_from_gellery:
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent,3);
                break;
            case R.id.tv_add_from_gallery:

                break;
            case R.id.btn_register:
                    startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                break;

            default:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data!=null){
            Uri selectedImage = data.getData();
            ImageView imageView = findViewById(R.id.iv_add_from_gellery);
            imageView.setImageURI(selectedImage);
        }
    }
}