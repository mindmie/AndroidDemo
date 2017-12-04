package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Question4Activity extends AppCompatActivity {

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
                    break;
                case R.id.btn_13day:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    break;
                case R.id.btn_35day:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    break;
                case R.id.btn_everyday:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    break;
                case R.id.btn_2timeday:
                    startActivity(new Intent(getApplicationContext(),Question5Activity.class));
                    break;
            }
        }
    }

}
