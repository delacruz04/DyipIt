package com.example.arvin.dyipit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class admin_login extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.admin_login);

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
         if(currentUser!=null){
                    Intent i = new Intent(getBaseContext(), admin_home.class);
                    startActivity(i);

                } //check if user is logged in

    }
    public void LoginUser(View v)
    {
        EditText mEdit;
        EditText pass;
        mEdit=(EditText)findViewById(R.id.editEmail);
        pass=(EditText)findViewById(R.id.editPass);

        String email=mEdit.getText().toString().trim();
        String password= pass.getText().toString().trim();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("4ITF", "signInWithEmail:success");

                            Intent i = new Intent(getBaseContext(), admin_home.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(i);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("4ITF", "signInWithEmail:failure", task.getException());
                            Toast.makeText(admin_login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void forgot(View v){
        Intent i = new Intent(getBaseContext(), admin_forgot.class);
        startActivity(i);

    }



}
