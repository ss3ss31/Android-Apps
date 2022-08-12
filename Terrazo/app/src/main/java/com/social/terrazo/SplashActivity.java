package com.social.terrazo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.social.terrazo.ui.login.LoginActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Intent intent = new Intent(this, LoginActivity.class);
        //~~~

        // not secure
        ParseUser.logInInBackground(getString(R.string.USER), getString(R.string.PASSWORD), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    // Hooray! The user is logged in.
                    Log.i("i",e.toString() + "sucess");
                    user.signUpInBackground();
                    e.printStackTrace();
                } else {
                    // Signup failed. Look at the ParseException to see what happened.
                    Log.i("i",e.toString() + "failure");
                    e.printStackTrace();
                }

                ParseAnalytics.trackAppOpenedInBackground(getIntent());
            }
        });


        //~~~

        startActivity(intent);
    }
}