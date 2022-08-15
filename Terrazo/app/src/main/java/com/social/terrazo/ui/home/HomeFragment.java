package com.social.terrazo.ui.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.social.terrazo.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //--

            Button getthedata;
            getthedata = binding.btndata;
            getthedata.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //ParseInstallation.getCurrentInstallation().saveInBackground();
                    ParseObject gameScore = new ParseObject("newObject");
                    gameScore.put("score", 1337);
                    gameScore.put("playerName", "Sean Plott");
                    gameScore.put("cheatMode", false);
                    gameScore.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                // Success!
                                Log.i("i",e.toString() + "sucess");
                                e.printStackTrace();
                            } else {
                                // Failure!
                                Log.i("i",e.toString() + "failure");
                                e.printStackTrace();
                            }
                        }
                    });
                    Toast.makeText(getContext(), "Button clicked", Toast.LENGTH_LONG).show();
                }
            });



        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
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