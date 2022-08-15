package com.example.socialapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialapp.Models.ChildModel;
import com.example.socialapp.Models.ParentModel;
import com.example.socialapp.R;

import java.util.ArrayList;

public class ParentRecyclerViewAdapter extends RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder> {
    private ArrayList<ParentModel> parentModelArrayList;
    public Context cxt;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView category;
        public RecyclerView childRecyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            category = itemView.findViewById(R.id.Section_title);
            childRecyclerView = itemView.findViewById(R.id.Child_RV);
        }
    }

    public ParentRecyclerViewAdapter(ArrayList<ParentModel> exampleList, Context context) {
        this.parentModelArrayList = exampleList;
        this.cxt = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_parent_recyclerview_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return parentModelArrayList.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ParentModel currentItem = parentModelArrayList.get(position);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(cxt, LinearLayoutManager.HORIZONTAL, false);
        holder.childRecyclerView.setLayoutManager(layoutManager);
        holder.childRecyclerView.setHasFixedSize(true);

        ArrayList<ChildModel> arrayList = new ArrayList<>();

        // added the first child row
        if (parentModelArrayList.get(position).sectionTitle().equals("Circles")) {
            arrayList.add(new ChildModel(R.drawable.add_new,"Add New"));
            arrayList.add(new ChildModel(R.drawable.ui8,"UI8"));
            arrayList.add(new ChildModel( R.drawable.unfold,"Unfold"));
            arrayList.add(new ChildModel( R.drawable.netguru,"Netguru"));
            arrayList.add(new ChildModel( R.drawable.ola,"ola"));
            arrayList.add(new ChildModel(R.drawable.ui8,"UI8"));
            arrayList.add(new ChildModel( R.drawable.unfold,"Unfold"));
            arrayList.add(new ChildModel( R.drawable.netguru,"Netguru"));
            arrayList.add(new ChildModel( R.drawable.ola,"ola"));
        }

        ChildRecyclerViewAdapter childRecyclerViewAdapter = new ChildRecyclerViewAdapter(arrayList,holder.childRecyclerView.getContext());
            holder.childRecyclerView.setAdapter(childRecyclerViewAdapter);
        }

}