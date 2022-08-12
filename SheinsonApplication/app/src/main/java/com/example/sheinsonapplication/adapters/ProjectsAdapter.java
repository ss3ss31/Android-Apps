package com.example.sheinsonapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sheinsonapplication.R;

public class ProjectsAdapter extends ArrayAdapter<String> implements SpinnerAdapter {

    String [] names;
    String [] descs;
    Drawable [] drawables;
    private Context mContext;
    int styleTemplate;




    public ProjectsAdapter(@NonNull Context context, int myStyleTemplate, String [] myNames,Drawable [] mDrawable, String [] myDescs ) {
        super(context, myStyleTemplate);
        this.names=myNames;
        this.descs=myDescs;
        this.drawables =mDrawable;
        this.styleTemplate=myStyleTemplate;
        this.mContext=context;

    }





    @Override
    public int getCount() {
        return names.length;
    }

    @SuppressLint("ResourceType")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        try {
            if (convertView == null) {
                if (styleTemplate == R.layout.project_item_view) {
                    LayoutInflater mInflater = (LayoutInflater) mContext.
                            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = mInflater.inflate(styleTemplate, parent, false);
                    mViewHolder.image = (ImageView) convertView.findViewById(R.id.project_item_image);
                    mViewHolder.name = (TextView) convertView.findViewById(R.id.project_item_title);
                    mViewHolder.desc = (TextView) convertView.findViewById(R.id.project_item_desc);


                    convertView.setTag(mViewHolder);
                }
            } else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }


            if(styleTemplate==R.layout.project_item_view)
            {
                if(drawables[position]==null){
                    mViewHolder.image.setBackgroundResource(R.drawable.no_image);
                    mViewHolder.name.setText(R.string.project_item_title);
                    mViewHolder.desc.setText(R.string.project_item_description);
                }else {
                    mViewHolder.image.setBackground(drawables[position]);
                    mViewHolder.name.setText(names[position]);
                    mViewHolder.desc.setText(descs[position]);
                }
            }
            else {
                if(drawables[position]==null){
                    mViewHolder.image.setBackgroundResource(R.drawable.no_image);
                }else {
                    mViewHolder.image.setBackgroundResource(Integer.parseInt(drawables[position].toString()));
                    mViewHolder.name.setText(names[position]);
                    mViewHolder.desc.setVisibility(View.GONE);
                    if (descs != null) {
                        mViewHolder.desc.setVisibility(View.VISIBLE);
                        mViewHolder.desc.setText(descs[position]);
                    }
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return convertView;

    }
    static class ViewHolder{
        ImageView image;
        TextView name ;
        TextView desc;
    }

}
