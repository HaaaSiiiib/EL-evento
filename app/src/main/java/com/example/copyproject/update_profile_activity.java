package com.example.copyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class update_profile_activity extends AppCompatActivity {

    private EditText userName, userphoneno,userinstitution;
    private Button saveButton;
    private FirebaseAuth firebaseAuth;
    String email, name, institution,phone,keyid,password,confirmpassword;
    DatabaseReference databaseReference;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_activity);
        userName = (EditText)findViewById(R.id.etUserrname);

       // userEmail = (EditText)findViewById(R.id.etUserEmail);
        userinstitution=findViewById(R.id.etuserrinstitution);
        userphoneno=findViewById(R.id.etuserrphoneno);
        saveButton = (Button)findViewById(R.id.bt_save_buttonid);

        firebaseAuth=FirebaseAuth.getInstance();
        keyid=firebaseAuth.getCurrentUser().getUid();
        databaseReference=FirebaseDatabase.getInstance().getReference().child(keyid);



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                student_userprofile userProfile=dataSnapshot.getValue(student_userprofile.class);
                password=userProfile.getUserpassword();
                email=userProfile.getUseremail();
                confirmpassword=userProfile.getUserconfirmpassword();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = userName.getText().toString();
                //email = userEmail.getText().toString();
                phone=userphoneno.getText().toString();
                institution=userinstitution.getText().toString();

                student_userprofile studentUserprofile = new student_userprofile(name,email,phone,institution,password,confirmpassword);
                databaseReference.setValue(studentUserprofile);


                Intent intent=new Intent(update_profile_activity.this,studentprofile_activity.class);
                startActivity(intent);
                finish();



            }
        });


    }
}
