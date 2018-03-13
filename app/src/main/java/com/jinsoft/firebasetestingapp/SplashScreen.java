package com.jinsoft.firebasetestingapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(LoginPage.class)
                .withSplashTimeOut(5000)
                .withBackgroundColor(Color.parseColor("#074E72"))
                .withLogo(R.mipmap.ic_launcher)
                .withHeaderText("Welcome!")
                .withFooterText("Copyright JinSoft 2018")
                .withBeforeLogoText("JinSoft")
                .withAfterLogoText("--------------------------------------");

        config.getHeaderTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);

        View view = config.create();

        setContentView(view);



    }
}
