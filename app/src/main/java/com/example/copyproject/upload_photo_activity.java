package com.example.copyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class upload_photo_activity extends AppCompatActivity implements  View.OnClickListener{

    private Button skipbutton,uploadpicbutton;
    private TextView skipmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_photo_activity);
        skipbutton=findViewById(R.id.bt_skipbutton);
        uploadpicbutton=findViewById(R.id.bt_uploadbutton);


        skipbutton.setOnClickListener(this);
        uploadpicbutton.setOnClickListener(this);


    }

    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.bt_uploadbutton:
                //update pic  er kaj baki

            case R.id.bt_skipbutton:

                Intent intent =new Intent(upload_photo_activity.this, event_participation_choice_activity.class);
                startActivity(intent);

               finish();

        }

    }

}
