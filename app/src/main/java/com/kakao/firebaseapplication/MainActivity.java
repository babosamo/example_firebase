package com.kakao.firebaseapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener{

    private static final String TAG = "MainActivity";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.emailButton).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.emailButton){
            startActivity(new Intent(this, EmailActivity.class));
        }
    }
}
