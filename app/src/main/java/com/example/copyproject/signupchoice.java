package com.example.copyproject;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class signupchoice extends AppCompatActivity implements View.OnClickListener {

    private Button signInButtonStudent,signInButtonSponsor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupchoice);

        signInButtonStudent=findViewById(R.id.signInButtonStudentId);
        signInButtonSponsor=findViewById(R.id.signInButtonSponsorId);

        signInButtonStudent.setOnClickListener(this);
        signInButtonSponsor.setOnClickListener(this);
    }
    public void onClick(View v) {

        switch(v.getId())
        {
            case R.id.signInButtonSponsorId:
                //sponsor er kaj baki

            case R.id.signInButtonStudentId:

                Intent intent =new Intent(getApplicationContext(), signup_studentinfopage.class);
                startActivity(intent);

                break;

        }

    }
}
