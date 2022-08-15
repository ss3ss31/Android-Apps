package com.example.socialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class GetStartedActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_form_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // find view by id
        btn_form_next = (Button) findViewById(R.id.btn_gs_form_next);

        // on click listner
        btn_form_next.setOnClickListener(this);



    }


    @Override
    public void onClick(View view) {


        switch (view.getId())
        {
            case R.id.btn_gs_form_next:
                checkLogin(true);
                break;



            default:

                break;

        }

    }

    private void checkLogin(boolean sucess) {

        if(sucess == true)
        {
            startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
        }else {

        }
    }
}