package com.bank.atm_app.ui.expenses;

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
import com.example.atm_app.databinding.FragmentExpensesBinding;

public class ExpensesFragment extends Fragment {

    private ExpensesViewModel expensesViewModel;
    private FragmentExpensesBinding binding;

    // Variables
    private RadioGroup RG_Currency_ex;
    private RadioButton radioButton_L_ex;
    private RadioButton radioButton_C_ex;
    private RadioButton radioButton_R_ex;

    private ImageView Graph_img;

    private RadioGroup radioTabs_ex;
    private RadioButton radioTab1_ex;
    private RadioButton radioTab2_ex;
    private RadioButton radioTab3_ex;

    //private Toolbar mToolBarT_ex;

    private ListView mListViewT_ex;
    //private ListView mListViewY_ex;

    private String[] tlistNames_ex = {"Expense Title","Pandora","Expense Title","Pandora"};
    private String[] tlistDesc_ex  = {"Monthly Description","Expense Description","Monthly Description","Expense Description"};
    private int[]    tlistImgs_ex  = {R.drawable.imgitem1,R.drawable.imgitem2,R.drawable.imgitem3,R.drawable.imgitem4};

    private String[] tlistNames_in  = {"Pandora","Income Title","Pandora","Income Title"};
    private String[] tlistDesc_in   = {"Income Description","Monthly Description","Income Description","Monthly Description"};
    private int[]    tlistImgs_in   = {R.drawable.imgitem1,R.drawable.imgitem2,R.drawable.imgitem3,R.drawable.imgitem4};

    private String[] tlistNames_to = {"Total Title","Pandora","Total Title","Pandora"};
    private String[] tlistDesc_to  = {"Total Description","Monthly Description","Total Description","Monthly Description"};
    private int[]    tlistImgs_to  = {R.drawable.imgitem1,R.drawable.imgitem2,R.drawable.imgitem3,R.drawable.imgitem4};

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;

    private int count = 0 ;
    //--

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        expensesViewModel =
                new ViewModelProvider(this).get(ExpensesViewModel.class);

        binding = FragmentExpensesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //--
        //initialize Objects  + "view."findviewbyID(R.id...);
        RG_Currency_ex =  (RadioGroup)  root.findViewById(R.id.rg_currency_ex);
        radioButton_L_ex = (RadioButton) root.findViewById(R.id.RadioButton_L_ex);
        radioButton_C_ex = (RadioButton) root.findViewById(R.id.RadioButton_C_ex);
        radioButton_R_ex = (RadioButton) root.findViewById(R.id.RadioButton_R_ex);

        Graph_img = (ImageView) root.findViewById(R.id.imageView_ex);

        radioTabs_ex = (RadioGroup) root.findViewById(R.id.radioTabs_ex);
        radioTab1_ex = (RadioButton) root.findViewById(R.id.radioTab1_ex);
        radioTab2_ex = (RadioButton) root.findViewById(R.id.radioTab2_ex);
        radioTab3_ex = (RadioButton) root.findViewById(R.id.radioTab3_ex);

        radioTab1_ex.setBackgroundResource(R.drawable.tabs_style);
        radioTab2_ex.setBackgroundResource(R.drawable.tabs_style);
        radioTab3_ex.setBackgroundResource(R.drawable.tabs_style);

        //mToolBarT_ex=(Toolbar)root.findViewById(R.id.toolbar1_ex);

        mListViewT_ex=(ListView)root.findViewById(R.id.lv_home1_ex);

        tv1 = (TextView)root.findViewById(R.id.textView1_ex);
        tv2 = (TextView)root.findViewById(R.id.textView2_ex);
        tv3 = (TextView)root.findViewById(R.id.textView3_ex);
        tv4 = (TextView)root.findViewById(R.id.textView4_ex);

        tv1.setText(tv1.getText());
        tv2.setText(tv2.getText());
        tv3.setText(tv3.getText());
        tv4.setText(tv4.getText());

        //functions
        radioButton_L_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_L_ex.setBackgroundResource(R.drawable.rounded_corner_view_clicked);//   (,R.drawable.rounded_corner_view_clicked,null));
                radioButton_L_ex.setTextColor(getResources().getColor(R.color.white));
                radioButton_C_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_C_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_R_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_R_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
            }
        });
        radioButton_C_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_C_ex.setBackgroundResource(R.drawable.rounded_corner_view_clicked);
                radioButton_C_ex.setTextColor(getResources().getColor(R.color.white));
                radioButton_L_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_L_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_R_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_R_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
            }
        });
        radioButton_R_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioButton_R_ex.setBackgroundResource(R.drawable.rounded_corner_view_clicked);
                radioButton_R_ex.setTextColor(getResources().getColor(R.color.white));
                radioButton_L_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_L_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
                radioButton_C_ex.setBackgroundColor(getResources().getColor(R.color.transparent));
                radioButton_C_ex.setTextColor(getResources().getColor(R.color.very_dark_blue));
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

        Graph_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //--

        //Today List
        //mToolBarT_ex.setTitle(getResources().getString(R.string.app_name));
        MyAdapter myAdapter=new MyAdapter(getContext(),R.layout.listview_item, tlistNames_in,tlistImgs_in,tlistDesc_in);
        mListViewT_ex.setAdapter(myAdapter);

        mListViewT_ex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                mIntent.putExtra("listNames_to",tlistNames_to[i]);
                mIntent.putExtra("listImgs_to",  tlistDesc_to [i]);
                mIntent.putExtra("listDescs_to", tlistImgs_to [i]);

                count = 10;
                mIntent.putExtra("10",count);
                startActivity(mIntent);

            }
        });
        //--

        radioTab1_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioTab1_ex.setBackgroundResource(R.drawable.tabs_style_clicked);
                radioTab2_ex.setBackgroundResource(R.drawable.tabs_style);
                radioTab3_ex.setBackgroundResource(R.drawable.tabs_style);

                //Today List
                //mToolBarT_ex.setTitle(getResources().getString(R.string.app_name));
                MyAdapter myAdapter=new MyAdapter(getContext(),R.layout.listview_item, tlistNames_in,tlistImgs_in,tlistDesc_in);
                mListViewT_ex.setAdapter(myAdapter);

                mListViewT_ex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                        mIntent.putExtra("listNames_in",tlistNames_in[i]);
                        mIntent.putExtra("listImgs_in", tlistImgs_in [i]);
                        mIntent.putExtra("listDescs_in", tlistDesc_in [i]);
                        count = 3;
                        mIntent.putExtra("3",count);
                        startActivity(mIntent);

                    }
                });
            }
        });
        radioTab2_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioTab1_ex.setBackgroundResource(R.drawable.tabs_style);
                radioTab2_ex.setBackgroundResource(R.drawable.tabs_style_clicked);
                radioTab3_ex.setBackgroundResource(R.drawable.tabs_style);



                //Today List
                //mToolBarT_ex.setTitle(getResources().getString(R.string.app_name));
                MyAdapter myAdapter=new MyAdapter(getContext(),R.layout.listview_item, tlistNames_ex,tlistImgs_ex,tlistDesc_ex);
                mListViewT_ex.setAdapter(myAdapter);

                mListViewT_ex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                        mIntent.putExtra("listNames_ex",tlistNames_ex [i]);
                        mIntent.putExtra("listImgs_ex", tlistImgs_ex  [i]);
                        mIntent.putExtra("listDesc_ex", tlistDesc_ex  [i]);
                        count = 9;
                        mIntent.putExtra("9",count);

                        startActivity(mIntent);

                    }
                });
            }
        });
        radioTab3_ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioTab1_ex.setBackgroundResource(R.drawable.tabs_style);
                radioTab2_ex.setBackgroundResource(R.drawable.tabs_style);
                radioTab3_ex.setBackgroundResource(R.drawable.tabs_style_clicked);


                //Today List
                //mToolBarT_ex.setTitle(getResources().getString(R.string.app_name));
                MyAdapter myAdapter=new MyAdapter(getContext(),R.layout.listview_item, tlistNames_to,tlistImgs_to,tlistDesc_to);
                mListViewT_ex.setAdapter(myAdapter);

                mListViewT_ex.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                        mIntent.putExtra("listNames_to",tlistNames_to[i]);
                        mIntent.putExtra("listImgs_to", tlistImgs_to [i]);
                        mIntent.putExtra("lsteDesc_to", tlistDesc_to [i]);
                        count = 4;
                        mIntent.putExtra("4",count);
                        startActivity(mIntent);

                    }
                });
            }
        });
        //--

        //final TextView textView = binding.textExpenses;
        expensesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
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