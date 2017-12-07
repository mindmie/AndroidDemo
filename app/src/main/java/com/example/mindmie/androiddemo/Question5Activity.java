package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question5Activity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference WeightLoseRef = mRootRef.child("Want to Weight Lose:");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_yes).setOnClickListener(new Question5Activity.InnerOnClickListener());
        findViewById(R.id.btn_no).setOnClickListener(new Question5Activity.InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_yes:
                    startActivity(new Intent(getApplicationContext(),Question61Activity.class));
                    WeightLoseRef.setValue("Yes");
                    break;
                case R.id.btn_no:
                    startActivity(new Intent(getApplicationContext(),Question6Activity.class));
                    WeightLoseRef.setValue("No");
                    break;
            }
        }
    }
}
