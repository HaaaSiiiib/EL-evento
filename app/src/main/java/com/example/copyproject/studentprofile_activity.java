package com.example.copyproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class studentprofile_activity extends AppCompatActivity {


    private TextView institution,name,email,phone ;
    private Button updatebutton;
    private FirebaseAuth firebaseAuth ;
    private FirebaseDatabase firebaseDatabase ;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentprofile_activity);

        name=findViewById(R.id.et_profile_name);
        institution=findViewById(R.id.et_institution);
        email=findViewById(R.id.et_email);
        phone=findViewById(R.id.et_phone_no);
        updatebutton=findViewById(R.id.bt_update_button);
        updatebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(studentprofile_activity.this,update_profile_activity.class);
                startActivity(intent);
                finish();
            }
        });

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                student_userprofile userProfile=dataSnapshot.getValue(student_userprofile.class);
                name.setText("Name:  "+userProfile.getUsername());
                email.setText("Email:  "+userProfile.getUseremail());
                institution.setText("Institution:  "+userProfile.getUserinstitution());
                phone.setText("Phone No.:  "+userProfile.getUserphoneno());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

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
            Intent intent = new Intent(studentprofile_activity.this,login_Activity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }


}
