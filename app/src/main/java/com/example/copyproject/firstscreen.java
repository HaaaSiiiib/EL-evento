package com.example.copyproject;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;


/* package whatever; // don't place package name! */

//package com.example.profiledataretrieve;
public class firstscreen extends AppCompatActivity {

    //private ProgressBar progressBar;
    private int progress;
    // FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstscreen);
        //this.setTitle("Welcome");
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //progressBar=findViewById(R.id.progressBar_id);

        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                Intent intent=new Intent(firstscreen.this, login_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();
        //backbutton
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //mAuth = FirebaseAuth.getInstance();
    }

    public void doWork(){

       // for (progress=20;progress<=100;progress=progress+20)
        {try {
            Thread.sleep(1200);
            //progressBar.setProgress(progress);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }}

    }
    //menu added
    // @Override
   /* public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_signout,menu);

        return super.onCreateOptionsMenu(menu);

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){

            this.finish();
        }
        if(item.getItemId()==R.id.sign_out_id)
        {
           FirebaseAuth.getInstance().signOut();
           finish();
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }*/



}
