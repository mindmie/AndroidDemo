package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question61Activity extends AppCompatActivity {
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question61);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question61Activity.InnerOnClickListener());

    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{

        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key");
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next:
                    Intent intent = new Intent( Question61Activity.this , Question7Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("key", text); // send key to next activity
                    startActivity(intent);

                    EditText Day = (EditText) findViewById(R.id.et_goal_weight);
                    String stringDay = Day.getText().toString();


                    databaseUser.child(text).child("username").child("Weight Control's Goal").setValue(stringDay);

                    break;

            }
        }
    }
}
