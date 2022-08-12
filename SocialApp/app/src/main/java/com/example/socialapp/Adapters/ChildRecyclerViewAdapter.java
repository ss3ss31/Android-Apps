package com.example.socialapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.socialapp.ItemActivity;
import com.example.socialapp.Models.ChildModel;
import com.example.socialapp.R;

import java.util.ArrayList;



public class ChildRecyclerViewAdapter extends RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder> implements View.OnClickListener {
    public ArrayList<ChildModel> childModelArrayList;
    Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView profileImageCirle;
        public TextView profileName;

        public MyViewHolder(View itemView) {
            super(itemView);
                profileImageCirle = itemView.findViewById(R.id.item_iv_circle);
                profileName = itemView.findViewById(R.id.profile_name);
        }
    }

    public ChildRecyclerViewAdapter(ArrayList<ChildModel> arrayList, Context mContext) {
        this.cxt = mContext;
        this.childModelArrayList = arrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_child_recyclerview_items, parent, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ChildModel currentItem = childModelArrayList.get(position);

        holder.profileImageCirle.setImageResource(currentItem.getProfileImage());

        holder.profileName.setText(currentItem.getProfileName());

        holder.profileImageCirle.setOnClickListener(this);
        holder.profileName.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return childModelArrayList.size();
    }

    @Override
    public void onClick(View view) {
        Intent mIntent = new Intent(view.getContext(), ItemActivity.class);

        view.getContext().startActivity(mIntent);
    }
}