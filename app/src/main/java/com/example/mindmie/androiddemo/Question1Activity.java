package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Question1Activity extends AppCompatActivity {

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
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_male:
                    startActivity(new Intent(getApplicationContext(),Question2Activity.class));
                    break;
                case R.id.btn_female:
                    startActivity(new Intent(getApplicationContext(),Question2Activity.class));
                    break;
            }
        }
    }
}
