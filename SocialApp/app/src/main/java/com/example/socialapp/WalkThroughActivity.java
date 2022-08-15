package com.example.socialapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WalkThroughActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup radioGroup;
    RadioButton wT_btn1,wT_btn2,wT_btn3;
    ImageView img1,img2,img3;
    TextView btn_next,btn_skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        // navigate into walkthrough
        radioGroup = (RadioGroup) findViewById(R.id.radio_group_walkthrough);
        wT_btn1    = (RadioButton) findViewById(R.id.btn1_walk);
        wT_btn2    = (RadioButton) findViewById(R.id.btn2_walk);
        wT_btn3    = (RadioButton) findViewById(R.id.btn3_walk);
        wT_btn1.setChecked(true);
        // images in the walkthrough
        img1 = (ImageView) findViewById(R.id.iv_walkthrough_1);
        img2 = (ImageView) findViewById(R.id.iv_walkthrough_2);
        img3 = (ImageView) findViewById(R.id.iv_walkthrough_3);
        // buttons continue the flow
        btn_next= (TextView) findViewById(R.id.button_next);
        btn_skip= (TextView) findViewById(R.id.button_skip);

        // images walk throw
        img1.setImageResource(R.drawable.walkthrough);
        img2.setImageResource(R.drawable.walkthrough);
        img3.setImageResource(R.drawable.walkthrough);

        // on click item
        wT_btn1.setOnClickListener(this);
        wT_btn2.setOnClickListener(this);
        wT_btn3.setOnClickListener(this);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        btn_next.setOnClickListener(this);
        btn_skip.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {

        // select each view
        switch (view.getId())
        {
            case R.id.btn1_walk:
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.GONE);
                wT_btn1.setChecked(true);
                wT_btn2.setChecked(false);
                wT_btn3.setChecked(false);
                break;

            case R.id.btn2_walk:
                img1.setVisibility(View.GONE);
                img2.setVisibility(View.VISIBLE);
                img3.setVisibility(View.GONE);
                wT_btn1.setChecked(false);
                wT_btn2.setChecked(true);
                wT_btn3.setChecked(false);
                break;

            case  R.id.btn3_walk:
                img1.setVisibility(View.GONE);
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.VISIBLE);
                wT_btn1.setChecked(false);
                wT_btn2.setChecked(false);
                wT_btn3.setChecked(true);
                break;

            case R.id.button_next:

                if(wT_btn1.isChecked()==true) {
                    view.setId(R.id.btn2_walk);


                }
                if(wT_btn2.isChecked()==true) {
                    view.setId(R.id.btn3_walk);

                }
                if(wT_btn3.isChecked()==true) {
                    startActivity( new Intent(getApplicationContext(),GetStartedActivity.class));

                }else {
                    startActivity( new Intent(getApplicationContext(),GetStartedActivity.class));

                }
                break;

            case R.id.button_skip:
                startActivity( new Intent(getApplicationContext(),GetStartedActivity.class));
                break;

            case R.id.iv_walkthrough_1:
                break;
            case R.id.iv_walkthrough_2:
                break;
            case R.id.iv_walkthrough_3:
                break;

            default:
                img1 = (ImageView) findViewById(R.id.iv_walkthrough_1);
                img1.setVisibility(View.VISIBLE);
                img2.setVisibility(View.GONE);
                img3.setVisibility(View.GONE);
                wT_btn1.setChecked(true);
                wT_btn2.setChecked(false);
                wT_btn3.setChecked(false);
                break;
        }
    }
}