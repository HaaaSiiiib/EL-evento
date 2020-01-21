package com.example.copyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class event_participation_choice_activity extends AppCompatActivity {

    private Button createventButton,joinEventButton,FundeventButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_participation_choice_activity);
        createventButton=findViewById(R.id.bt_createevent_button);



        createventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(event_participation_choice_activity.this,Eventdetails_Activity.class));
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_logout_layout,menu);

        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){

            this.finish();
        }
        if(item.getItemId()==R.id.logout_id)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            Intent intent = new Intent(event_participation_choice_activity.this,login_Activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }



}
