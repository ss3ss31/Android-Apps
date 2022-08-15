package com.bank.atm_app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bank.atm_app.DetailsActivity;
import com.bank.atm_app.adapters.MyAdapter;
import com.example.atm_app.R;
import com.example.atm_app.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    //variables
    private RadioGroup RG_Currency;
    private RadioButton radioButton_L;
    private RadioButton radioButton_C;
    private RadioButton radioButton_R;
    private ImageView Graph_img;
    private ImageView Graph_img_bt;
//    TextView tv1,tv2,tv3,tv4,tv5,tv6;
//    int sumNumber;
//    String sign_currency;


    //--

    //private Toolbar mToolBarT;
    //private Toolbar mToolBarY;
    private ListView mListViewT;
    private ListView mListViewY;
    private String[] tlistNames = {"Today"};
    private String[] tlistDesc={"DescOfPandora"};
    private int[] tlistImgs={R.drawable.transitemimg};
    private String[] ylistNames = {"Yesterday","Past"};
    private String[] ylistDesc={"DescOfPandora","DescOfpndora2"};
    private int[] ylistImgs={R.drawable.transitemimg,R.drawable.buttons_icon};
    private int count = 0 ;

    //--

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //initialize Objects  + "view."findviewbyID(R.id...);
        RG_Currency =  (RadioGroup) root.findViewById(R.id.rg_currency);
        radioButton_L = (RadioButton) root.findViewById(R.id.RadioButton_L);
        radioButton_C = (RadioButton) root.findViewById(R.id.RadioButton_C);
        radioButton_R = (RadioButton) root.findViewById(R.id.RadioButton_R);

        Graph_img = (ImageView) root.findViewById(R.id.imageView);
        Graph_img_bt = (ImageView) root.findViewById(R.id.imageView2);


        //mToolBarT=(Toolbar)root.findViewById(R.id.toolbar1);
        //mToolBarY=(Toolbar)root.findViewById(R.id.toolbar2);
        mListViewT=(ListView)root.findViewById(R.id.lv_home1);
        mListViewY=(ListView)root.findViewById(R.id.lv_home2);


        TextView tv1 = (TextView)root.findViewById(R.id.textView1);
        TextView tv2 = (TextView)root.findViewById(R.id.textView2);
        TextView tv3 = (TextView)root.findViewById(R.id.textView3);
        TextView tv4 = (TextView)root.findViewById(R.id.textView4);
        TextView tv5 = (TextView)root.findViewById(R.id.textView5);
        TextView tv6 = (TextView)root.findViewById(R.id.textView6);



        tv1.setText(tv1.getText());
        tv2.setText(tv2.getText());
        tv3.setText(tv3.getText());
        tv4.setText(tv4.getText());
        tv5.setText(tv5.getText());
        tv6.setText(tv6.getText());


        //functions

        radioButton_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_L.setBackgroundResource(R.drawable.rounded_corner_view_clicked);//   (,R.drawable.rounded_corner_view_clicked,null));
                radioButton_L.setTextColor(getResources().getColor(R.color.white));
                radioButton_C.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_C.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_R.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_R.setTextColor(getResources().getColor(R.color.very_dark_blue));
            }
        });
        radioButton_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_C.setBackgroundResource(R.drawable.rounded_corner_view_clicked);
                radioButton_C.setTextColor(getResources().getColor(R.color.white));
                radioButton_L.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_L.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_R.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_R.setTextColor(getResources().getColor(R.color.very_dark_blue));
            }
        });
        radioButton_R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_R.setBackgroundResource(R.drawable.rounded_corner_view_clicked);
                radioButton_R.setTextColor(getResources().getColor(R.color.white));
                radioButton_L.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_L.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_C.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_C.setTextColor(getResources().getColor(R.color.very_dark_blue));
            }
        });

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        tv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Graph_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Graph_img_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //--


        //Today List
        //mToolBarT.setTitle(getResources().getString(R.string.app_name));
        MyAdapter myAdapter=new MyAdapter(this.mListViewT.getContext(),R.layout.listview_item, tlistNames,tlistImgs,tlistDesc);
        mListViewT.setAdapter(myAdapter);

        mListViewT.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                mIntent.putExtra("listNames",tlistNames[i]);
                mIntent.putExtra("listImgs",tlistImgs[i]);
                mIntent.putExtra("listDesc",tlistDesc[i]);
                count = 1;
                mIntent.putExtra("1",count);

                startActivity(mIntent);

            }
        });


        //Yesterday List
        //mToolBarY.setTitle(getResources().getString(R.string.app_name));
        MyAdapter myAdapterY=new MyAdapter(this.mListViewY.getContext(),R.layout.listview_item,ylistNames,ylistImgs,ylistDesc);
        mListViewY.setAdapter(myAdapterY);

        mListViewY.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                mIntent.putExtra("ylistNames",ylistNames[i]);
                mIntent.putExtra("ylistImgs",ylistImgs[i]);
                mIntent.putExtra("ylistDesc",ylistDesc[i]);
                count = 2;
                mIntent.putExtra("2",count);
                startActivity(mIntent);
            }
        });


        //--

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);


            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}