package com.example.arvin.dyipit;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent i = new Intent(getBaseContext(), ActionUser.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        }.start();
    }

    @Override
    protected void onStart() {

        super.onStart();
        new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {

            }

            public void onFinish() {
                Intent i = new Intent(getBaseContext(), ActionUser.class);
               //not allow back on splash
                startActivity(i);
            }
        }.start();


    }

}
