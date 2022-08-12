package com.example.socialapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ItemActivity extends AppCompatActivity {

    Toolbar mToolBar;
    ImageView mImageView;
    TextView mTextView , mImageViewTime;
    int mBundle_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);


        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mImageView =(ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.tv_name);
        mImageViewTime = (TextView) findViewById(R.id.tv_time);


        //Bundle mBundle = getIntent().getExtras();

        //getIntent().getExtras().getInt(String.valueOf(1));

        mToolBar.setTitle("title toolbar");
        mImageView.setImageResource(R.drawable.moana);
        mTextView.setText("title2");

 /*
        // TODO: continue the switch
        switch (mBundle_count) {

            case String.valueOf(1):
                mToolBar.setTitle(mBundle.getString());
                mImageView.setImageResource(mBundle.getInt());
                mTextView.setText(mBundle.getString());
                break;

/*
            case 2:
                mToolBar .setTitle(mBundle.getString("ylistNames"));
                mImageView.setImageResource(mBundle.getInt("ylistImgs"));
                mTextView.setText(mBundle.getString("ylistDesc"));
                break;
            case 3:
                mToolBar .setTitle(mBundle.getString("listNames_in"));
                mImageView.setImageResource(mBundle.getInt("listImgs_in"));
                mTextView.setText(mBundle.getString("listDescs_in"));
                break;
            case 4:
                mToolBar .setTitle(mBundle.getString("listNames_to"));
                mImageView.setImageResource(mBundle.getInt("listImgs_to"));
                mTextView.setText(mBundle.getString("lsteDesc_to"));
                break;
            case 5:
                mToolBar.setTitle(mBundle.getString("listNames_ac"));
                mImageView.setImageResource(mBundle.getInt("listImgs_ac"));
                break;
            case 6:
                mToolBar.setTitle(mBundle.getString("listNames_rc"));
                mImageView.setImageResource(mBundle.getInt("listImgs_rc"));
                break;
            case 7:
                mToolBar.setTitle(mBundle.getString("listNames_all"));
                mImageView.setImageResource(mBundle.getInt("listImgs_all"));
                break;
            case 8:
                mToolBar.setTitle(mBundle.getString("title_no"));
                mImageView.setImageResource(mBundle.getInt("imgs_no"));
                mTextView.setText(mBundle.getString("desc_no"));
                break;
            case 9: 
                mToolBar .setTitle(mBundle.getString("listNames_ex"));
                mImageView.setImageResource(mBundle.getInt("listImgs_ex"));
                mTextView.setText(mBundle.getString("listDesc_ex"));
                break;
            case 10:
                mToolBar .setTitle(mBundle.getString("listNames_to"));
                mImageView.setImageResource(mBundle.getInt("listImgs_to"));
                mTextView.setText(mBundle.getString("listDescs_to"));
                break;
            case 11:


                break;
            default:

                break;
        }

    */



    }
}