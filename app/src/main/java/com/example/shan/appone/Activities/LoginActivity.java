package com.example.shan.appone.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shan.appone.R;

public class LoginActivity extends AppCompatActivity {

    Button btnSkipLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSkipLogin = (Button) findViewById(R.id.btnSkipLogin);
        btnSkipLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent mainScreenActivity = new Intent(LoginActivity.this, MainScreenActivity.class);
                startActivity(mainScreenActivity);
            }
        });
    }




}

