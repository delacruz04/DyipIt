package com.example.arvin.dyipit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.*;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class admin_home extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference root;
    TextView MinFare;
    EditText editText;
    private String value;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.admin_home);
        database=FirebaseDatabase.getInstance();
        MinFare= findViewById(R.id.MinumumFare);
        FirebaseDatabase.getInstance();


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("message");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    Log.d("Read","Gumana");

                        MinFare.setText(dataSnapshot.getValue().toString());

                }else{
                    MinFare.setText("MALI");
                    Log.d("Read","Hindi Gumana");

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    protected void onStart(){

        super.onStart();
        database=FirebaseDatabase.getInstance();
        MinFare= findViewById(R.id.MinumumFare);
        FirebaseDatabase.getInstance();


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("message");


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    Log.d("Read","Gumana");

                    MinFare.setText(dataSnapshot.getValue().toString());

                }else{
                    MinFare.setText("MALI");
                    Log.d("Read","Hindi Gumana");

                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void SignOut(View v){

        mAuth.signOut();
        Intent i = new Intent(this, ActionUser.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);


    }





    public void getRecord(View v){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("message");

        editText=findViewById(R.id.editFare);
        String value=editText.getText().toString();


        reference.setValue(value);
        //update data into database
    }









}
