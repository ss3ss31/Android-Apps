package com.bank.atm_app.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bank.atm_app.DetailsActivity;
import com.bank.atm_app.adapters.MyAdapter;
import com.example.atm_app.R;
import com.bank.atm_app.SelectRecipientActivity;
import com.example.atm_app.databinding.FragmentAccountBinding;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;
    private FragmentAccountBinding binding;

    //Variabales

    private int count = 0;
    //private Toolbar mToolBarT_ac;

    private GridView mListViewT_ac;

    private String[] tlistNames_ac ={"Insurance","Savings","Credits","Investments"};
    private int[]    tlistImgs_ac={R.drawable.iconlist_ac_insurance,R.drawable.iconlist_ac_saving,R.drawable.iconlist_ac_credits,R.drawable.iconlist_ac_investments};

    ImageView icon_listlb;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);

        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //initialize Objects  + "view."findviewbyID(R.id...);
       // mToolBarT_ac=(Toolbar)root.findViewById(R.id.toolbar1_ac);
        mListViewT_ac=(GridView)root.findViewById(R.id.gvg_account);
        icon_listlb= (ImageView) root.findViewById(R.id.list_lb);




        icon_listlb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //TODO: change the path on click
                Intent mIntent = new Intent(getActivity(), SelectRecipientActivity.class);
                startActivity(mIntent);
            }
        });

        //Today List
        //mToolBarT_ac.setTitle(getResources().getString(R.string.app_name));
        MyAdapter myAdapter=new MyAdapter(getContext(),R.layout.listview_grid, tlistNames_ac,tlistImgs_ac);
        mListViewT_ac.setAdapter(myAdapter);

        mListViewT_ac.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), DetailsActivity.class);
                mIntent.putExtra("listNames_ac",tlistNames_ac [i]);
                mIntent.putExtra("listImgs_ac", tlistImgs_ac  [i]);
                count = 5;
                mIntent.putExtra("5",count);
                startActivity(mIntent);

            }
        });



        //final TextView textView = binding.textAccount;
        accountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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