package com.social.orderfood.Adapter;

import android.content.Context;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.social.orderfood.Activity.CartListActivity;
import com.social.orderfood.Domain.FoodDomain;
import com.social.orderfood.Helper.ManagementCart;
import com.social.orderfood.Interface.ChangeNumberItemListner;
import com.social.orderfood.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {

    private ArrayList<FoodDomain> foodDomains;
    private ManagementCart managementCart;
    private ChangeNumberItemListner changeNumberItemListner;

    public CartListAdapter(ArrayList<FoodDomain> foodDomains, Context context, ChangeNumberItemListner changeNumberItemListner) {
        this.foodDomains = foodDomains;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemListner = changeNumberItemListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(foodDomains.get(position).getFee()));
        holder.totalEachItem.setText(String.valueOf(Math.round((foodDomains.get(position).getNumberInCart()*foodDomains.get(position).getFee())*100)/100));
        holder.num.setText(String.valueOf(foodDomains.get(position).getNumberInCart()));

        int drawableReasourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic()
                ,"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableReasourceId)
                .into(holder.pic);



            holder.plusItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    managementCart.plusNumberFood(foodDomains, position, new ChangeNumberItemListner() {
                        @Override
                        public void changed() {
                            notifyDataSetChanged();
                            changeNumberItemListner.changed();
                        }
                    });
                }
            });

            holder.minusItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    managementCart.minusNumberFood(foodDomains, position, new ChangeNumberItemListner() {
                        @Override
                        public void changed() {
                            notifyDataSetChanged();
                            changeNumberItemListner.changed();
                        }
                    });
                }
            });
        }

        @Override
        public int getItemCount() {
            return foodDomains.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView title,feeEachItem;
            ImageView pic,plusItem,minusItem;
            TextView totalEachItem,num;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                title=itemView.findViewById(R.id.titleCartTxt);
                feeEachItem =itemView.findViewById(R.id.feeEachItem);
                pic= itemView.findViewById(R.id.picCart);
                plusItem=itemView.findViewById(R.id.plusCardBtn);
                minusItem=itemView.findViewById(R.id.minusCartBtn);
                totalEachItem=itemView.findViewById(R.id.totalEachItem);
                num =itemView.findViewById(R.id.numberItemTxt);


            }
        }
    }
