package com.example.socialapp.Models;

import androidx.recyclerview.widget.RecyclerView;

public class ParentModel {
    private String sectionTitle;
    private RecyclerView sectionRecyclerView;


    public ParentModel(String sectionTitle) {
        this.sectionTitle = sectionTitle;
    }
    public String sectionTitle() {
        return sectionTitle;
    }



}