package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question4Activity extends AppCompatActivity {
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();

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

        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key");
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_noexercise:
                    Intent intent1 = new Intent( Question4Activity.this , Question5Activity.class);
                    intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent1.putExtra("key", text); // send key to next activity
                    startActivity(intent1);
                    databaseUser.child(text).child("username").child("ActivityLevel").setValue("No Exercise");
                    break;
                case R.id.btn_13day:
                    Intent intent2 = new Intent( Question4Activity.this , Question5Activity.class);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent2.putExtra("key", text); // send key to next activity
                    startActivity(intent2);

                    databaseUser.child(text).child("username").child("ActivityLevel").setValue("1 - 3 Day");
                    break;
                case R.id.btn_35day:
                    Intent intent3 = new Intent( Question4Activity.this , Question5Activity.class);
                    intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent3.putExtra("key", text); // send key to next activity
                    startActivity(intent3);

                    databaseUser.child(text).child("username").child("ActivityLevel").setValue("3 - 5 Day");
                    break;
                case R.id.btn_everyday:
                    Intent intent4 = new Intent( Question4Activity.this , Question5Activity.class);
                    intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent4.putExtra("key", text); // send key to next activity
                    startActivity(intent4);

                    databaseUser.child(text).child("username").child("ActivityLevel").setValue("Everyday");
                    break;
                case R.id.btn_2timeday:
                    Intent intent = new Intent( Question4Activity.this , Question5Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("key", text); // send key to next activity
                    startActivity(intent);

                    databaseUser.child(text).child("username").child("ActivityLevel").setValue("2 Time per Day");
                    break;
            }
        }
    }

}
