package com.social.orderfood.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.social.orderfood.Domain.FoodDomain;
import com.social.orderfood.Helper.ManagementCart;
import com.social.orderfood.R;

public class ShowDetailActivity extends AppCompatActivity {

    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,descriptionTxt,numberOrderTxt;
    private ImageView plusBtn,minusBtn,picFood;
    private FoodDomain object;
    int numberOder=1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

            managementCart = new ManagementCart(this);
            initView();
            getBundle();

    }
    private void getBundle(){
        object=(FoodDomain) getIntent().getSerializableExtra("object");
        int drawableReasourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableReasourceId)
                .into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOder=numberOder+1;
                numberOrderTxt.setText(String.valueOf(numberOder));
            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOder>1){
                    numberOder=numberOder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOder));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOder);
                managementCart.insertFood(object);
            }
        });



    }

    private void initView(){
        addToCartBtn =findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        descriptionTxt=findViewById(R.id.decriptionTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn =findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picFood);

    }
}