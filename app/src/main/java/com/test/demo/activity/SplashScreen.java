package com.test.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.demo.MainActivity;
import com.test.demo.R;

public class SplashScreen extends AppCompatActivity {

    private final int SPLASH_TIME=2000;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs",Context.MODE_PRIVATE);
                String mStr_name=sharedPreferences.getString("NAME","");
                String mStr_password=sharedPreferences.getString("PASSWORD","");

                if(mStr_name.length()>0 && mStr_password.length()>0){
                    Intent mainIntent = new Intent(SplashScreen.this, LoginDetails.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();}

                    else{
                    Intent mainIntent = new Intent(SplashScreen.this, Login.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }
            }
        },SPLASH_TIME);
    }
}
