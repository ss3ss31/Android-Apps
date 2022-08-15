package com.bank.atm_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.atm_app.R;

public class DetailsActivity extends AppCompatActivity {

    Toolbar mToolBar;
    ImageView mImageView;
    TextView mTextView;
    int mBundle_count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        mToolBar =(Toolbar) findViewById(R.id.toolbar_detail);
        mImageView =(ImageView) findViewById(R.id.profileImageItem);
        mTextView = (TextView) findViewById(R.id.details_desc);

        Bundle mBundle = getIntent().getExtras();
        mBundle_count = getIntent().getExtras().getInt("1",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("2",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("3",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("4",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("5",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("6",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("6",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("7",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("8",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("9",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("10",mBundle_count);
        mBundle_count = getIntent().getExtras().getInt("11",mBundle_count);


/*
        if(mBundle != null)
        {
            mToolBar .setTitle(mBundle.getString("listNames"));
            mImageView.setImageResource(mBundle.getInt("listImgs"));

        }

*/

             // TODO: continue the switch
            switch (mBundle_count)
            {

                case 1://v
                    mToolBar .setTitle(mBundle.getString("listNames"));
                    mImageView.setImageResource(mBundle.getInt("listImgs"));
                    mTextView.setText(mBundle.getString("listDesc"));
                    break;
                case 2://v
                    mToolBar .setTitle(mBundle.getString("ylistNames"));
                    mImageView.setImageResource(mBundle.getInt("ylistImgs"));
                    mTextView.setText(mBundle.getString("ylistDesc"));
                    break;
                case 3: //v
                    mToolBar .setTitle(mBundle.getString("listNames_in"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_in"));
                    mTextView.setText(mBundle.getString("listDescs_in"));
                    break;
                case 4: // v
                    mToolBar .setTitle(mBundle.getString("listNames_to"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_to"));
                    mTextView.setText(mBundle.getString("lsteDesc_to"));
                    break;
                case 5://v
                    mToolBar.setTitle(mBundle.getString("listNames_ac"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_ac"));
                    break;
                case 6://v
                    mToolBar.setTitle(mBundle.getString("listNames_rc"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_rc"));
                    break;
                case 7://v
                    mToolBar.setTitle(mBundle.getString("listNames_all"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_all"));
                    break;
                case 8://v
                    mToolBar.setTitle(mBundle.getString("title_no"));
                    mImageView.setImageResource(mBundle.getInt("imgs_no"));
                    mTextView.setText(mBundle.getString("desc_no"));
                    break;
                case 9: //v
                    mToolBar .setTitle(mBundle.getString("listNames_ex"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_ex"));
                    mTextView.setText(mBundle.getString("listDesc_ex"));
                    break;
                case 10://v
                    mToolBar .setTitle(mBundle.getString("listNames_to"));
                    mImageView.setImageResource(mBundle.getInt("listImgs_to"));
                    mTextView.setText(mBundle.getString("listDescs_to"));
                    break;
                case 11:


                    break;
                default:

                    break;
            }

/*
        // TODO: check if posible to change to switch
        if (mBundle != null) {
            mToolBar .setTitle(mBundle.getString("listNames"));
            mImageView.setImageResource(mBundle.getInt("listImgs"));
        } else if (mBundle != null) {
            mToolBar .setTitle(mBundle.getString("listNames_ex"));
            mImageView.setImageResource(mBundle.getInt("listImgs_ex"));
        } else if (mBundle != null) {
            mToolBar .setTitle(mBundle.getString("listNames_in"));
            mImageView.setImageResource(mBundle.getInt("listImgs_in"));
        } else if (mBundle != null) {
            mToolBar .setTitle(mBundle.getString("listNames_to"));
            mImageView.setImageResource(mBundle.getInt("listImgs_to"));
        } else if (mBundle != null) {
            mToolBar.setTitle(mBundle.getString("listNames_ac"));
            mImageView.setImageResource(mBundle.getInt("listImgs_ac"));
        }else if (mBundle != null) {
            mToolBar.setTitle(mBundle.getString("listNames_rc"));
            mImageView.setImageResource(mBundle.getInt("listImgs_rc"));
        }else if (mBundle != null) {
            mToolBar.setTitle(mBundle.getString("listNames_all"));
            mImageView.setImageResource(mBundle.getInt("listImgs_all"));
        }
 */



    }
}