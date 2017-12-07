package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question9Activity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference ThingRef = mRootRef.child("You More Serious:");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question9);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_preferDish).setOnClickListener(new Question9Activity.InnerOnClickListener());
        findViewById(R.id.btn_costDish).setOnClickListener(new Question9Activity.InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_preferDish:
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    ThingRef.setValue("PREFERENCE DISH");
                    break;
                case R.id.btn_costDish:
                    startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    ThingRef.setValue("CODE DISH");
                    break;
            }
        }
    }
}
