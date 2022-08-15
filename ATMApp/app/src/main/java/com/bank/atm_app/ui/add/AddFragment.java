package com.bank.atm_app.ui.add;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.bank.atm_app.TransferCompleteActivity;
import com.bank.atm_app.ExchangeActivity;
import com.example.atm_app.R;
import com.bank.atm_app.SelectRecipientActivity;
import com.example.atm_app.databinding.FragmentAddBinding;
import com.bank.atm_app.ui.login.LoginActivity;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    private FragmentAddBinding binding;

    private Button bt_sc,bt_proc,bt_exchange,bt_login;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                new ViewModelProvider(this).get(AddViewModel.class);

        binding = FragmentAddBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //find view by id
        bt_sc = (Button) root.findViewById(R.id.bt_select_rc);
        bt_proc = (Button) root.findViewById(R.id.bt_proc);
        bt_exchange = (Button) root.findViewById(R.id.bt_excange);
        bt_login =(Button) root.findViewById(R.id.bt_login);

        //--


        bt_sc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), SelectRecipientActivity.class);
                startActivity(mIntent);
            }
        });
        bt_proc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), TransferCompleteActivity.class);
                startActivity(mIntent);
            }
        });
        bt_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), ExchangeActivity.class);
                startActivity(mIntent);
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getActivity(), LoginActivity.class);
                startActivity(mIntent);
            }
        });


        //--
        final TextView textView = binding.textAdd;
        addViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
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