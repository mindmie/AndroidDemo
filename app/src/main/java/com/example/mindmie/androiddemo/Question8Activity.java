package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question8Activity extends AppCompatActivity {
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question8);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question8Activity.InnerOnClickListener());

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
                    Intent intent = new Intent( Question8Activity.this , Question9Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("key", text); // send key to next activity
                    startActivity(intent);


                    Spinner rank1 = (Spinner) findViewById(R.id.spn_first_meat);
                    Spinner rank2 = (Spinner) findViewById(R.id.spn_second_meat);
                    Spinner rank3 = (Spinner) findViewById(R.id.spn_third_meat);
                    String StringRank1 = rank1.getSelectedItem().toString();
                    String StringRank2 = rank2.getSelectedItem().toString();
                    String StringRank3 = rank3.getSelectedItem().toString();

                    databaseUser.child(text).child("username").child("Meat").child("1st").setValue(StringRank1);
                    databaseUser.child(text).child("username").child("Meat").child("2nd").setValue(StringRank2);
                    databaseUser.child(text).child("username").child("Meat").child("3rd").setValue(StringRank3);
                    break;

            }
        }
    }
}
