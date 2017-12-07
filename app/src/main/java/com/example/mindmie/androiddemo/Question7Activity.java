package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question7Activity extends AppCompatActivity {
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference RankPrefer1Ref = mRootRef.child("Rank 1 Prefer Flavor:");
    DatabaseReference RankPrefer2Ref = mRootRef.child("Rank 2 Prefer Flavor:");
    DatabaseReference RankPrefer3Ref = mRootRef.child("Rank 3 Prefer Flavor:");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        initView();
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question7Activity.InnerOnClickListener());

    }

    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next:
                    startActivity(new Intent(getApplicationContext(),Question8Activity.class));
                    Spinner rank1 = (Spinner) findViewById(R.id.spn_first_flavour);
                    Spinner rank2 = (Spinner) findViewById(R.id.spn_second_flavour);
                    Spinner rank3 = (Spinner) findViewById(R.id.spn_third_flavour);
                    String StringRank1 = rank1.getSelectedItem().toString();
                    String StringRank2 = rank2.getSelectedItem().toString();
                    String StringRank3 = rank3.getSelectedItem().toString();
                    RankPrefer1Ref.setValue(StringRank1);
                    RankPrefer2Ref.setValue(StringRank2);
                    RankPrefer3Ref.setValue(StringRank3);
                    break;

            }
        }
    }
}
