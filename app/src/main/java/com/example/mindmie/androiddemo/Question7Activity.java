package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question7Activity extends AppCompatActivity {
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
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
        Bundle bundle = getIntent().getExtras();
        String text = bundle.getString("key");
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_next:
                    Intent intent = new Intent( Question7Activity.this , Question8Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("key", text); // send key to next activity
                    startActivity(intent);

                    Spinner rank1 = (Spinner) findViewById(R.id.spn_first_flavour);
                    Spinner rank2 = (Spinner) findViewById(R.id.spn_second_flavour);
                    Spinner rank3 = (Spinner) findViewById(R.id.spn_third_flavour);
                    String StringRank1 = rank1.getSelectedItem().toString();
                    String StringRank2 = rank2.getSelectedItem().toString();
                    String StringRank3 = rank3.getSelectedItem().toString();


                    databaseUser.child("username").child(text).child("Flavour").child("1st").setValue(StringRank1);
                    databaseUser.child("username").child(text).child("Flavour").child("2nd").setValue(StringRank2);
                    databaseUser.child("username").child(text).child("Flavour").child("3rd").setValue(StringRank3);


                    break;

            }
        }
    }
}
