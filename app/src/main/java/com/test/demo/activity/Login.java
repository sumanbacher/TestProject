package com.test.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.test.demo.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText mEt_username, mEt_password;
    private Button mBtn_submit;
    CheckBox mCheckbox;
    SharedPreferences mSharedPreferences;
    private Button btnNewOne;


    private String mStr_username, mStr_password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEt_username = findViewById(R.id.et_activity_login_username);
        mEt_password = findViewById(R.id.et_activity_login_password);
        mBtn_submit = findViewById(R.id.btn_activity_login_submit);
        mCheckbox = findViewById(R.id.check_activity_login);
        mBtn_submit.setOnClickListener(this);

        mSharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        mCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putString("NAME", mEt_username.getText().toString().trim());
                    editor.putString("PASSWORD", mEt_password.getText().toString().trim());
                    editor.commit();
                }
                else{
                        //////////Do nothing
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == mBtn_submit) {
            if (mEt_username.getText().toString().trim().length() > 0) {

                if (mEt_password.getText().toString().trim().length() > 0) {

                    if(mEt_password.getText().toString().trim().equals("admin") && mEt_username.getText().toString().trim().equals("admin")){
                        startActivity(new Intent(this, LoginDetails.class));
                    }
                    else{
                        Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    mEt_password.setError("Enter Password");
                }
            } else {
                mEt_username.setError("Enter user Name");
            }
        }
    }
}
