package com.example.mindmie.androiddemo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question3Activity extends AppCompatActivity {
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference WeightRef = mRootRef.child("Weight :");
    DatabaseReference HeightRef = mRootRef.child("Height :");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question3Activity.InnerOnClickListener());

    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next:
                    startActivity(new Intent(getApplicationContext(),Question4Activity.class));
                    EditText Weight = (EditText) findViewById(R.id.et_weight);
                    EditText Height = (EditText) findViewById(R.id.et_height);
                    String stringWeight = Weight.getText().toString();
                    String stringHeight = Height.getText().toString();
                    WeightRef.setValue(stringWeight);
                    HeightRef.setValue(stringHeight);
                    break;

            }
        }
    }
}
