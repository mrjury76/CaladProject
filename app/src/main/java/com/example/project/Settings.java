package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button logout, back, changePassword;

        logout = findViewById(R.id.logoutButton);
        back = findViewById(R.id.backButton);
        changePassword = findViewById(R.id.passwordChangeButton);

        //back button just takes user back to main activity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.this, MainActivity.class));
            }
        });


        //TODO - add logout functionality. Make user session management first?
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //TODO
            }
        });

        //TODO - change user password functionality
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });

    }
}
