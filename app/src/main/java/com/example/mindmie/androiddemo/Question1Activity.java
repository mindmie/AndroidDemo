package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Question1Activity extends AppCompatActivity {

    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        initView();
    }



    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_male).setOnClickListener(new Question1Activity.InnerOnClickListener());
        findViewById(R.id.btn_female).setOnClickListener(new Question1Activity.InnerOnClickListener());

    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
         // get key from another activity
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key");
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_male:


                    Intent intent_male = new Intent( getApplicationContext() , Question2Activity.class);
                    intent_male.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent_male.putExtra("key", text); // send key to next activity
                    startActivity(intent_male);

                    // push gender to database
                    databaseUser.child("username").child(text).child("Gender").setValue("Male");

                    // update to database
//                   HashMap<String,Object> postValues = new HashMap<>();
//                   postValues.put( "Gender", "Male");
//
//
//                   HashMap<String,Object> childUpdate = new HashMap<>();
//                   childUpdate.put("/users/", postValues);
//                   databaseUser.updateChildren(childUpdate);
                    break;
                case R.id.btn_female:

                    Intent intent_female = new Intent( getApplicationContext() , Question2Activity.class);
                    intent_female.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent_female.putExtra("key", text); // send key to next activity
                    startActivity(intent_female);

                    // push gender to database
                    databaseUser.child(text).child("username").child("Gender").setValue("Female");
                    break;
            }


        }
    }
}
