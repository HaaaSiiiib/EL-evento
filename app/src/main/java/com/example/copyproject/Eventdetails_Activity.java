package com.example.copyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Eventdetails_Activity extends AppCompatActivity {


    private EditText eventname, eventdate, location;
    private Button done;
    private FirebaseAuth firebaseAuth;
    String event_name, event_date, event_location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails_);
        eventname = findViewById(R.id.eventname_id);
        eventdate = findViewById(R.id.eventdate_id);
        location = findViewById(R.id.location_id);

        done=findViewById(R.id.buttondone);
        firebaseAuth = FirebaseAuth.getInstance();

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validate()) {
                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference myRef;/// = firebaseDatabase.getReference(firebaseAuth.getUid());
                    String postuid = FirebaseDatabase.getInstance().getReference().child("event").push().getKey().toString();

                    // System.out.println("ASASAS "+postuid);

                    Eventdetails event = new Eventdetails(event_name, event_date, event_location,FirebaseAuth.getInstance().getUid());
                    myRef = firebaseDatabase.getReference().child("event").child(postuid);
                 ///   FirebaseAuth.getInstance().getUid();

                    myRef.setValue(event);

                }
            }
        });


    }

    private Boolean validate() {
        Boolean result = false;
        event_name = eventname.getText().toString();
        event_date = eventdate.getText().toString();
        event_location = location.getText().toString();

        if (event_name.isEmpty() || event_date.isEmpty() || event_location.isEmpty()) {
            Toast.makeText(Eventdetails_Activity.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }

        return result;
    }




}
