package com.example.shan.appone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btnSkipLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO

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

