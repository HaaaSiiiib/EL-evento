package com.example.copyproject;


import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;


public class signup_studentinfopage extends AppCompatActivity {

    private EditText userName, userPassword, userEmail, userconfirmpassword,userphoneno,userinstitution;
    private Button signupButton;
    private FirebaseAuth firebaseAuth;
    String email, name, password,confirmpassword,institution,phone, dummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_studentinfopage);
        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();



        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){
                    //Upload data to the database
                    String user_email = userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful()){
                                sendUserData();
                                firebaseAuth.signOut();
                                Toast.makeText(signup_studentinfopage.this, "Successfully Registered, Upload complete!", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(signup_studentinfopage.this, upload_photo_activity.class));
                                finish();
                            }else{
                                Toast.makeText(signup_studentinfopage.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });


    }

    private void setupUIViews(){
        userName = (EditText)findViewById(R.id.etUserName);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        userconfirmpassword=findViewById(R.id.etuserconfirmpassword);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userinstitution=findViewById(R.id.etuserinstitution);
        userphoneno=findViewById(R.id.etuserphoneno);
        signupButton = (Button)findViewById(R.id.btsignupButton);
    }

    private Boolean validate(){
        Boolean result = false;

        name = userName.getText().toString();
        password = userPassword.getText().toString();
        email = userEmail.getText().toString();
        phone=userphoneno.getText().toString();
        confirmpassword=userconfirmpassword.getText().toString();
        institution=userinstitution.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty()||institution.isEmpty()||confirmpassword.isEmpty()){
            Toast.makeText(signup_studentinfopage.this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }
        if(password.length()<7)
        {

            Toast.makeText(signup_studentinfopage.this, "Enter a password with min 7 digits", Toast.LENGTH_SHORT).show();

        }
        else if(!password.equals(confirmpassword))
        {

            Toast.makeText(signup_studentinfopage.this, "Please enter same password", Toast.LENGTH_SHORT).show();
        }
        else{
            result = true;
        }

        return result;
    }


    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef;/// = firebaseDatabase.getReference(firebaseAuth.getUid());
      /////  String postuid=FirebaseDatabase.getInstance().getReference().child("event").push().getKey().toString();

       //// System.out.println("ASASAS "+postuid);

        student_userprofile studentUserprofile = new student_userprofile(name,email,phone,institution,password,confirmpassword);
         myRef = firebaseDatabase.getReference().child("user").child(FirebaseAuth.getInstance().getUid());
         myRef.setValue(studentUserprofile);
       ///// myRef.setValue(studentUserprofile);
    }
}