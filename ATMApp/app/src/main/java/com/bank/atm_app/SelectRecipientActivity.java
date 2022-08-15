package com.bank.atm_app;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import com.bank.atm_app.adapters.MyAdapter;
import com.example.atm_app.R;

public class SelectRecipientActivity extends AppCompatActivity {

    MultiAutoCompleteTextView multiAutoCompleteTextView;
    TextView tvRecipientAddItem,tvRecent,tvAll;
    //variable
    private int count=0;
    ListView lvRecent,lvAll;

    ImageView sc_AddImage;

    private String[] tlistNames_rc = {"Expense Title","Pandora","Expense Title","Pandora"};
    private int[]    tlistImgs_rc  = {R.drawable.imgitem1,R.drawable.imgitem2,R.drawable.imgitem3,R.drawable.imgitem4};

    private String[] tlistNames_all = {"Expense Title","Pandora","Expense Title","Pandora"};
    private int[]    tlistImgs_all  = {R.drawable.imgitem1,R.drawable.imgitem2,R.drawable.imgitem3,R.drawable.imgitem4};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_recipient);

         multiAutoCompleteTextView = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);
         tvRecipientAddItem =(TextView) findViewById(R.id.tv_recipient_add_item_rc);
         tvRecent =(TextView) findViewById(R.id.tv_recent_rc);
         tvAll =(TextView) findViewById(R.id.tv_all_rc);
         //toolbar_rc =findViewById(R.id.toolbar_rc);
         lvRecent =(ListView) findViewById(R.id.lv_recent_rc);
         lvAll = (ListView) findViewById(R.id.lv_all_rc);
         sc_AddImage = (ImageView)findViewById(R.id.sc_imageview_add);



        //Today List
       // toolbar_rc.setTitle(getResources().getString(R.string.app_name));
        MyAdapter myAdapter=new MyAdapter(this,R.layout.listview_item, tlistNames_rc,tlistImgs_rc);
        lvRecent.setAdapter(myAdapter);

        lvRecent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(SelectRecipientActivity.this, DetailsActivity.class);
                mIntent.putExtra("listNames_rc",tlistNames_rc[i]);
                mIntent.putExtra("listDescs_rc", tlistImgs_rc [i]);
                count = 6;
                mIntent.putExtra("6",count);
                startActivity(mIntent);

            }
        });



        //toolbar_rc.setTitle(getResources().getString(R.string.app_name));
        myAdapter=new MyAdapter(this,R.layout.listview_item, tlistNames_all,tlistImgs_all);
        lvAll.setAdapter(myAdapter);

        lvAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(SelectRecipientActivity.this, DetailsActivity.class);
                mIntent.putExtra("listNames_all",tlistNames_all[i]);
                mIntent.putExtra("listDescs_all", tlistImgs_all [i]);
                count = 7;
                mIntent.putExtra("7",count);
                startActivity(mIntent);

            }
        });

        sc_AddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                margeOnClick();
            }
        });
        tvRecipientAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                margeOnClick();
            }
        });



    }
    private void margeOnClick(){
        // same on click the + image and text
        Intent mIntent = new Intent(SelectRecipientActivity.this, AddToListActivity.class);

        count =11;
        mIntent.putExtra("11",count);
        startActivity(mIntent);

    }
}