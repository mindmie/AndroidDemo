package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question8Activity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference RankMeat1Ref = mRootRef.child("Rank 1 Prefer Meat:");
    DatabaseReference RankMeat2Ref = mRootRef.child("Rank 2 Prefer Meat:");
    DatabaseReference RankMeat3Ref = mRootRef.child("Rank 3 Prefer Meat:");
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
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next:
                    startActivity(new Intent(getApplicationContext(),Question9Activity.class));
                    Spinner rank1 = (Spinner) findViewById(R.id.spn_first_meat);
                    Spinner rank2 = (Spinner) findViewById(R.id.spn_second_meat);
                    Spinner rank3 = (Spinner) findViewById(R.id.spn_third_meat);
                    String StringRank1 = rank1.getSelectedItem().toString();
                    String StringRank2 = rank2.getSelectedItem().toString();
                    String StringRank3 = rank3.getSelectedItem().toString();
                    RankMeat1Ref.setValue(StringRank1);
                    RankMeat2Ref.setValue(StringRank2);
                    RankMeat3Ref.setValue(StringRank3);
                    break;

            }
        }
    }
}
