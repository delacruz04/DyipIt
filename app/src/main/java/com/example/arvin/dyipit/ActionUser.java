package com.example.arvin.dyipit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActionUser extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.action);
    }


    public void display2(View v) {
        Intent i = new Intent(this, admin_login.class);

        startActivity(i);
    }

    public void display3(View v) {
        Intent i = new Intent(this, MapsActivity.class);

        startActivity(i);
    }

}
