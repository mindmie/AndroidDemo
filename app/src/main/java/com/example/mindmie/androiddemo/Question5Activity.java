package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question5Activity extends AppCompatActivity {
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
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
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key");
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_yes:
                    Intent intent1 = new Intent( Question5Activity.this , Question61Activity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent1.putExtra("key", text); // send key to next activity
                    startActivity(intent1);
                    databaseUser.child(text).child("username").child("WeightLose").setValue("Yes");
                    break;
                case R.id.btn_no:
                    Intent intent2 = new Intent(Question5Activity.this ,Question6Activity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent2.putExtra("key", text); // send key to next activity
                    startActivity(intent2);
                    databaseUser.child(text).child("username").child("WeightLose").setValue("No");
                    break;
            }
        }
    }
}
