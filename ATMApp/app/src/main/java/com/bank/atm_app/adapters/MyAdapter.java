package com.bank.atm_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.atm_app.R;

public class MyAdapter extends ArrayAdapter<String> implements SpinnerAdapter {

    String [] names;
    String [] prices;
    String [] descs;
    int[] imgs;
    private Context mContext;
    int styleTemplate;



    public MyAdapter(@NonNull Context context,int myStyleTemplate,String [] myNames, int[] myImgs,String [] myDescs) {
        super(context, myStyleTemplate);
        this.names=myNames;
        this.descs=myDescs;
        this.imgs=myImgs;
        this.styleTemplate=myStyleTemplate;
        this.mContext=context;

    }
    public MyAdapter(@NonNull Context context,int myStyleTemplate,String [] myNames, int[] myImgs) {
        super(context, myStyleTemplate);
        this.names=myNames;
        this.imgs=myImgs;
        this.styleTemplate=myStyleTemplate;
        this.mContext=context;

    }




    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        try{
        if(convertView==null) {
            if(styleTemplate== R.layout.listview_item){
                LayoutInflater mInflater = (LayoutInflater) mContext.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(styleTemplate, parent, false);
                mViewHolder.image = (ImageView) convertView.findViewById(R.id.imageViewItem);
                mViewHolder.name = (TextView) convertView.findViewById(R.id.tvItem);
                mViewHolder.desc = (TextView) convertView.findViewById(R.id.descItem);
                mViewHolder.price = (TextView) convertView.findViewById(R.id.priceItem);
                convertView.setTag(mViewHolder);
            }else if(styleTemplate==R.layout.listview_grid){
                LayoutInflater mInflater = (LayoutInflater) mContext.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(styleTemplate, parent, false);
                mViewHolder.image = (ImageView) convertView.findViewById(R.id.icon_image);
                mViewHolder.name = (TextView) convertView.findViewById(R.id.tv_title);

                convertView.setTag(mViewHolder);
            }
        }else {
            mViewHolder =(ViewHolder) convertView.getTag();
        }

        if(styleTemplate==R.layout.listview_grid){
            mViewHolder.image.setImageResource(imgs[position]);
            mViewHolder.name.setText(names[position]);
        }else {
            mViewHolder.image.setImageResource(imgs[position]);
            mViewHolder.name.setText(names[position]);
            mViewHolder.desc.setVisibility(View.GONE);
            if(prices!=null){
                mViewHolder.price.setVisibility(View.VISIBLE);
                mViewHolder.price.setText(prices[position]);
            }
            if(descs!=null) {
                mViewHolder.desc.setVisibility(View.VISIBLE);
                mViewHolder.desc.setText(descs[position]);
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
        TextView price;
    }


    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        try {
            if (convertView == null) {
                   if(styleTemplate==android.R.layout.simple_spinner_item){
                LayoutInflater mInflater = (LayoutInflater) mContext.
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = mInflater.inflate(styleTemplate, parent, false);
                mViewHolder.name = (TextView) convertView.findViewById(R.id.tvItem);
                convertView.setTag(mViewHolder);
            }
            convertView.setTag(mViewHolder);

        }
        mViewHolder =(ViewHolder) convertView.getTag();

        }catch(Exception e){
            e.printStackTrace();
        }


        return super.getDropDownView(position, convertView, parent);
    }


}
