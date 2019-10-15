package com.test.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.demo.R;

public class LoginDetails extends AppCompatActivity implements View.OnClickListener {

    Button mBtn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_details);

        mBtn_logout=findViewById(R.id.btn_logindetails_logout);
        mBtn_logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==mBtn_logout){
            SharedPreferences sharedPreferences=getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.clear();
            editor.commit();

            startActivity(new Intent(this,SplashScreen.class));
        }
    }
}
