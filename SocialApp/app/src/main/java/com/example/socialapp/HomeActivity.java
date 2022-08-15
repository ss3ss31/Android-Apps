package com.example.socialapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialapp.Adapters.FeedAdapter;
import com.example.socialapp.Adapters.ParentRecyclerViewAdapter;
import com.example.socialapp.Models.ParentModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    //initilaize
    private RecyclerView parentRecyclerView;
    private RecyclerView.Adapter ParentAdapter;
    ArrayList<ParentModel> parentModelArrayList = new ArrayList<>();
    private RecyclerView.LayoutManager parentLayoutManager;

    //--
    private ListView mListView_one;
    private String[] listUserNames     =    {"User name #","User name #","User name #","User name #"};
    private int[]    featueListImgs    =    {R.drawable.moana,R.drawable.moana,R.drawable.moana,R.drawable.moana};
    private int[]    profileListImgs   =    {R.drawable.first_user,R.drawable.second_user,R.drawable.first_user,R.drawable.second_user,};
    private int[]    likeListImgs      =    {R.drawable.heart_empty,R.drawable.heart_empty,R.drawable.heart_empty,R.drawable.heart_empty};
    //--
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        //set the Categories for each array list set in the `ParentViewHolder

        parentModelArrayList.add(new ParentModel("Circles"));
//


        //find view by id
        parentRecyclerView = findViewById(R.id.circle_parent_recyclerView);
        mListView_one = findViewById(R.id.rounded_square_parent_ListView);

        // functions
        parentRecyclerView.setHasFixedSize(true);
        parentLayoutManager = new LinearLayoutManager(this);
        ParentAdapter = new ParentRecyclerViewAdapter(parentModelArrayList, HomeActivity.this);
        parentRecyclerView.setLayoutManager(parentLayoutManager);
        parentRecyclerView.setAdapter(ParentAdapter);
        ParentAdapter.notifyDataSetChanged();




        FeedAdapter feedAdapter = new FeedAdapter(this.mListView_one.getContext(),R.layout.square_item,listUserNames,featueListImgs,profileListImgs,likeListImgs);
        mListView_one.setAdapter(feedAdapter);








    }



}
