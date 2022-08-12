package com.social.terrazo;

import android.app.Application;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.http.ParseHttpRequest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.networkInterceptors().add(httpLoggingInterceptor);

        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.APP_ID))
                // if defined
                .clientKey(getString(R.string.CLIENT_KEY))
                .server(getString(R.string.SERVER_URL))
                .build()
        );

        ParseInstallation.getCurrentInstallation().saveInBackground();


        //---
        try {
            ParseUser.logIn(""+R.string.USER,""+R.string.PASSWORD).signUpInBackground();


        } catch (ParseException e) {
            e.printStackTrace();
        }
        ParseObject gameScore = new ParseObject("newObject");
        gameScore.put("score", 1337);
        gameScore.put("playerName", "Sean Plott1");
        gameScore.put("cheatMode", false);
        gameScore.saveInBackground();

        ParseInstallation.create(String.valueOf(gameScore));
        Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG).show();
        //---



        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);

    }
}