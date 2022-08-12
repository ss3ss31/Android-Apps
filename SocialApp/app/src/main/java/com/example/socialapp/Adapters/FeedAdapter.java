package com.example.socialapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.socialapp.ItemActivity;
import com.example.socialapp.R;
import com.google.android.material.imageview.ShapeableImageView;


public class FeedAdapter extends ArrayAdapter<String> implements View.OnClickListener {

    //var
    private Context mContext;
    int styleTemplate;
    private String[] listUserNames;
    private int[] featueListImgs;
    private int[] profileListImgs;
    private int[] likeListImgs;

    public FeedAdapter( Context mContext, int styleTemplate, String[] listUserNames, int[] featueListImgs, int[] profileListImgs, int[] likeListImgs) {
        super(mContext, styleTemplate);
        this.mContext = mContext;
        this.styleTemplate = styleTemplate;
        this.listUserNames = listUserNames;
        this.featueListImgs = featueListImgs;
        this.profileListImgs = profileListImgs;
        this.likeListImgs = likeListImgs;
    }

    public int getCount(){
        return listUserNames.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        if (position % 2 == 0){
            styleTemplate = R.layout.square_item;
        }else {
            styleTemplate = R.layout.square_two_item;
        }

        if(convertView == null){
                if (styleTemplate == R.layout.square_item) {
                    LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = mInflater.inflate(styleTemplate, parent, false);
                    mViewHolder.Featue_Image    = (ShapeableImageView) convertView.findViewById(R.id.feature_image_feed);
                    mViewHolder.Profile_Image   = (ShapeableImageView) convertView.findViewById(R.id.item_iv_user_circle_feed);
                    mViewHolder.UserNames       = (TextView) convertView.findViewById(R.id.profile_name_feed);
                    mViewHolder.Like_Image      = (ImageView) convertView.findViewById(R.id.like_image_feed);
                    convertView.setTag(mViewHolder);

                    mViewHolder.Featue_Image.setImageResource(featueListImgs[position]);
                    mViewHolder.UserNames.setText(listUserNames[position]);
                    mViewHolder.Profile_Image.setImageResource(profileListImgs[position]);
                    mViewHolder.Like_Image.setImageResource(likeListImgs[position]);

                    //--    onclicklistener
                    mViewHolder.Featue_Image.setOnClickListener(this);
                    mViewHolder.Profile_Image.setOnClickListener(this);
                    mViewHolder.UserNames.setOnClickListener(this);
                    mViewHolder.Like_Image.setOnClickListener(this);

                    if(position == 0){
                        mViewHolder.Featue_Image.setImageResource(R.drawable.post_one_img);
                    }
                    convertView.setTag(mViewHolder);
                }

            if(styleTemplate==R.layout.square_two_item){
                LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(styleTemplate, parent, false);
                mViewHolder.Featue_Image_one    = (ShapeableImageView) convertView.findViewById(R.id.feature_image_one_feed);
                mViewHolder.Featue_Image_two    = (ShapeableImageView) convertView.findViewById(R.id.feature_image_two_feed);
                mViewHolder.Profile_Image       = (ShapeableImageView) convertView.findViewById(R.id.item_iv_user_two_circle_feed);
                mViewHolder.UserNames           = (TextView) convertView.findViewById(R.id.profile_name_two_feed);
                mViewHolder.Like_Image          = (ImageView) convertView.findViewById(R.id.like_image_two_feed);
                mViewHolder.Featue_Image_one.setImageResource(featueListImgs[position]);
                mViewHolder.Featue_Image_two.setImageResource(featueListImgs[position]);

                mViewHolder.UserNames.setText(listUserNames[position]);
                mViewHolder.Profile_Image.setImageResource(profileListImgs[position]);
                mViewHolder.Like_Image.setImageResource(likeListImgs[position]);

                //--    onclicklistener
                mViewHolder.Featue_Image_one.setOnClickListener(this);
                mViewHolder.Featue_Image_two.setOnClickListener(this);
                mViewHolder.Profile_Image.setOnClickListener(this);
                mViewHolder.UserNames.setOnClickListener(this);
                mViewHolder.Like_Image.setOnClickListener(this);

                if(position == 1){
                    mViewHolder.Featue_Image_one.setImageResource(R.drawable.noma);
                    mViewHolder.Featue_Image_two.setImageResource(R.drawable.maskara);
                }
                convertView.setTag(mViewHolder);
            }  else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }
        }

        return convertView;
    }

    @Override
    public void onClick(View view) {
        Intent mIntent;
        switch (view.getId())
        {
            // go to details post
            case R.id.feature_image_feed:
            case R.id.feature_image_two_feed:
            case R.id.feature_image_one_feed:
                mIntent = new Intent(getContext(), ItemActivity.class);
                mIntent.putExtra("item","re-details");
                getContext().startActivity(mIntent);
                break;

                // go to user account
            case R.id.item_iv_user_circle_feed:
            case R.id.item_iv_user_two_circle_feed:
            case R.id.profile_name_feed:
            case R.id.profile_name_two_feed:
                mIntent = new Intent(getContext(), ItemActivity.class);
                mIntent.putExtra("user acount","re-link");
                getContext().startActivity(mIntent);
                break;

                //change the icon after clicl
            case R.id.like_image_feed:
            case R.id.like_image_two_feed:
                view.setBackgroundResource(R.drawable.heart_fill);
                break;
        }
    }

    static class ViewHolder
    {
        TextView           UserNames;
        ShapeableImageView Featue_Image;
        ShapeableImageView Featue_Image_one;
        ShapeableImageView Featue_Image_two;
        ShapeableImageView Profile_Image;
        ImageView          Like_Image;
    }
}