package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_login).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_register).setOnClickListener(new InnerOnClickListener());
    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_login:
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                    break;
                case R.id.btn_register:
                    startActivity(new Intent(getApplicationContext(),RegisActivity.class));
                    break;
            }
        }
    }
}
