package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Question6Activity extends AppCompatActivity {
    private EditText Weight;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        initView();
        Weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validate();
            }
        });
    }
    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question6Activity.InnerOnClickListener());
        Weight = (EditText) findViewById(R.id.et_weight);

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
                    if(validate()) {

                        Intent intent = new Intent( Question6Activity.this , Question7Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("key", text); // send key to next activity
                        startActivity(intent);


                        String stringWeight = Weight.getText().toString();

                        databaseUser.child("username").child(text).child("YourGoal").setValue(stringWeight);
                    }
                    else{
                        Toast.makeText(Question6Activity.this, "Please Enter Weight Goal", Toast.LENGTH_SHORT).show();

                    }


                    break;

            }
        }
    }
    private boolean validate(){
        boolean isValidated = true;
        if (Weight.getText().toString().length() == 0) {
            Weight.setError("Please Enter Weight Goal");
            isValidated = false;
        }
        return isValidated;
    }
}
