package com.example.sheinsonapplication.ui.contact;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.sheinsonapplication.R;
import com.example.sheinsonapplication.databinding.FragmentContactUsBinding;

public class ContactUsFragment extends Fragment {

    private ContactUsViewModel contactUsViewModel;
    private FragmentContactUsBinding binding;

    //--
    EditText et_name,et_email,et_phone,et_message;
    Button btn_send;

    //--


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        contactUsViewModel =
                new ViewModelProvider(this).get(ContactUsViewModel.class);

        binding = FragmentContactUsBinding.inflate(inflater,container,false);
        View root = binding.getRoot();

//--
        et_name = root.findViewById(R.id.form_full_name);
        et_email = root.findViewById(R.id.form_email);
        et_phone = root.findViewById(R.id.form_phone);
        et_message = root.findViewById(R.id.form_massage);

        btn_send = (Button) root.findViewById(R.id.btn_send_data);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name,email,phone,massage;
                name= String.valueOf(et_name.getText());
                email=String.valueOf(et_email.getText());
                phone =String.valueOf(et_phone.getText());
                massage = String.valueOf(et_message.getText());

                sendmail(name,email,phone,massage);
            }
        });

        //--

        final TextView textView = binding.textContactUs;
        contactUsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                textView.setText(s);
                binding.textContactUs.setText(R.string.title_contact_us);
            }
        });


        return root;
    }


    void sendmail(String name,String email,String phone,String massage){
        String subject = String.valueOf(R.string.new_lead);
        String bodyText;

        bodyText = "lead name: "+name + "\n\n\n"+massage;

        Log.i("bodyText","result: "+bodyText);
        try {

            String mailto = "mailto:"+ String.valueOf(R.string.email_title_contact_us_data) +
                    "?cc=" + "" +
                    "&subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(bodyText);

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse(mailto)); // my mail for tests

            startActivity(emailIntent);
        }
        catch (ActivityNotFoundException e){

        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}