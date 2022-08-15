package com.bank.atm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atm_app.R;

public class TransferCompleteActivity extends AppCompatActivity {

    ImageView   tr_complete;
    TextView    tv_title,tv_desc;
    Button      btn_procceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_complete);

        // Initialize
        tr_complete = (ImageView) findViewById(R.id.complete_icon);
        tv_title = (TextView) findViewById(R.id.complete_tv_title);
        tv_desc = (TextView) findViewById(R.id.complete_tv_description);
        btn_procceed = (Button) findViewById(R.id.btn_proc);

        // functions

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent mIntent = new Intent(TransferCompleteActivity.this,SelectRecipientActivity.class);
                startActivity(mIntent);
            }
        }).start();

        btn_procceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(TransferCompleteActivity.this,SelectRecipientActivity.class);
                startActivity(mIntent);
            }
        });

    }
}