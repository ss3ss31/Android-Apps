package com.bank.atm_app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.atm_app.R;


public class NotificationAdapter extends ArrayAdapter<String> {

    // Variable
    private Context mContext;
    int styleTemplate;
    int[] imgs;
    String[] title;
    String[] descs;
    int[] isRead;
    static boolean[] isItTrue;



    // Constractor
    public NotificationAdapter(Context mContext, int styleTemplate, int[] imgs, String[] title, String[] descs, int[] isRead) {
        super(mContext, styleTemplate);
        this.mContext = mContext;
        this.styleTemplate = styleTemplate;
        this.imgs = imgs;
        this.title = title;
        this.descs = descs;
        this.isRead = isRead;
        isItTrue = new boolean[isRead.length];

    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        try{
            if (convertView == null) {
                if (styleTemplate == R.layout.listview_notification) {

                    LayoutInflater mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = mLayoutInflater.inflate(styleTemplate, parent, false);

                    mViewHolder.imgs = (ImageView) convertView.findViewById(R.id.imageViewNotification);
                    mViewHolder.title = (TextView) convertView.findViewById(R.id.tv_Title_Notification);
                    mViewHolder.descs = (TextView) convertView.findViewById(R.id.tv_Description_Notification);
                    mViewHolder.isRead = (ImageView) convertView.findViewById(R.id.image_Status);

                    convertView.setTag(mViewHolder);

                    if (styleTemplate == R.layout.listview_notification) {

                        mViewHolder.title.setText(title[position]);
                        mViewHolder.descs.setText(descs[position]);
                        mViewHolder.imgs.setImageResource(imgs[position]);
                        mViewHolder.isRead.setImageResource(isRead[position]);
                    }
                    convertView.setTag(mViewHolder);
                }
                convertView.setTag(mViewHolder);
            }

                    mViewHolder = (ViewHolder) convertView.getTag();

        }catch(Exception e){
            e.printStackTrace();
        }

        return convertView;

    }





    @Override
    public int getCount () {
        return title.length;
    }


    static class ViewHolder {
        ImageView imgs;
        TextView title;
        TextView descs;
        ImageView isRead;
    }


}
