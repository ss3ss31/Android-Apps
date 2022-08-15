package com.bank.atm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.atm_app.R;

public class AddToListActivity extends AppCompatActivity {

    Button btn_add,btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);

        // hide top bar
        getSupportActionBar().hide();

        // initialize
        btn_add = (Button) findViewById(R.id.btn_atl_add_data);
        btn_cancel = (Button) findViewById(R.id.btn_atl_leave_data);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(AddToListActivity.this, TransferCompleteActivity.class);


                startActivity(mIntent);
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(AddToListActivity.this, SelectRecipientActivity.class);

                startActivity(mIntent);
            }
        });


    }
}