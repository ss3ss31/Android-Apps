package com.example.socialapp.Models;



public class ChildModel {
      private  int profile_image;
    private String profile_name;

    public ChildModel(int profile_image, String profile_name){
        this.profile_image = profile_image;
        this.profile_name = profile_name;
    }
    public int getProfileImage() {
        return profile_image;
    }
    public String getProfileName() {
        return profile_name;
    }

}