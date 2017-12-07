package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question4Activity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference exerciseRef = mRootRef.child("Exercise Per Week :");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_noexercise).setOnClickListener(new Question4Activity.InnerOnClickListener());
        findViewById(R.id.btn_13day).setOnClickListener(new Question4Activity.InnerOnClickListener());
        findViewById(R.id.btn_35day).setOnClickListener(new Question4Activity.InnerOnClickListener());
        findViewById(R.id.btn_everyday).setOnClickListener(new Question4Activity.InnerOnClickListener());
        findViewById(R.id.btn_2timeday).setOnClickListener(new Question4Activity.InnerOnClickListener());

    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_noexercise:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    exerciseRef.setValue("No Exercise");
                    break;
                case R.id.btn_13day:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    exerciseRef.setValue("1 - 3 Day");
                    break;
                case R.id.btn_35day:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    exerciseRef.setValue("3 - 5 Day");
                    break;
                case R.id.btn_everyday:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    exerciseRef.setValue("Everyday");
                    break;
                case R.id.btn_2timeday:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    exerciseRef.setValue("2 Time per Day");
                    break;
            }
        }
    }

}
