package com.savannah.aspectjproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.savannah.aspectjproject.annotation.LoginBehavior;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity >>>>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @LoginBehavior("login")
    public void loginCheck(View view) {
        Log.w(TAG, "loginCheck: ");
    }

    @LoginBehavior("login")
    public void login(View view) {
        Log.w(TAG, "login: ");
    }
}