package com.example.mindmie.androiddemo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Question2Activity extends AppCompatActivity {

    private static final String TAG = "Question2Activity";
    private String date;
    private TextView displayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        initView();
        displayDate = findViewById(R.id.et_date);

        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog= new DatePickerDialog(
                        Question2Activity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: dd/mm/yyyy" + day + "/" + month + "/" + year);
                date = day + "/" + month + "/" + year;
                displayDate.setText(date);
            }
        };

        displayDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditDate();
            }
        });
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_next).setOnClickListener(new Question2Activity.InnerOnClickListener());


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
                    if(validateEditDate()) {

                        Intent intent = new Intent( Question2Activity.this , Question3Activity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("key", text); // send key to next activity
                        startActivity(intent);


                        databaseUser.child("username").child(text).child("BirthDay").setValue(displayDate.getText().toString());


                    }
                    else{
                        Toast.makeText(Question2Activity.this, "Please Enter BirthDate", Toast.LENGTH_SHORT).show();

                    }

                    break;

            }
        }
    }

    private boolean validateEditDate(){
        boolean isValidated = true;
        if (date == null) {
            displayDate.setError("Please Enter BirthDate");
            isValidated = false;
        }



        return isValidated;
    }
}
