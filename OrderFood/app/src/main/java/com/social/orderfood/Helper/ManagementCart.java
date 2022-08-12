package com.social.orderfood.Helper;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.social.orderfood.Domain.FoodDomain;
import com.social.orderfood.Interface.ChangeNumberItemListner;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context){
        this.context=context;
        this.tinyDB=new TinyDB(context);
    }

    public void insertFood(FoodDomain item){
        ArrayList<FoodDomain> listFood= getListCart();
        boolean existAlready=false;

        int n=0;
        for (int i =0; i< listFood.size();i++){
            if (listFood.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }

        if(existAlready){
            listFood.get(n).setNumberInCart(item.getNumberInCart());
        }else {
            listFood.add(item);
        }

        tinyDB.putListObject("CartList",listFood);
        Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_LONG).show();
    }

    public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
    }
//--
    public void clearOnExitNumberFood(ArrayList<FoodDomain>listFood, ChangeNumberItemListner changeNumberItemListner){
       if (UsageEvents.Event.ACTIVITY_STOPPED==23)
           listFood.clear();
           tinyDB.putListObject("CartList", listFood);
         changeNumberItemListner.changed();

    }
    //--
    public void plusNumberFood(ArrayList<FoodDomain>listFood,int position, ChangeNumberItemListner changeNumberItemListner){
        listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemListner.changed();

    }

    public void minusNumberFood(ArrayList<FoodDomain>listFood,int position, ChangeNumberItemListner changeNumberItemListner){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }else {
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listFood);
        changeNumberItemListner.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> listfood=getListCart();
        double fee=0;
        for (int i=0 ; i < listfood.size(); i++){
            fee=fee+(listfood).get(i).getFee()*listfood.get(i).getNumberInCart();
        }
        return fee;
    }
}
