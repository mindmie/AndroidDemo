package com.example.mindmie.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindView();
        initView();
    }

    private void bindView(){

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pwd);
    }

    private void initView(){
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditEmail()) {
                    Toast.makeText(LoginActivity.this, "Okay. You Login Complete.", Toast.LENGTH_SHORT).show();
                    // SnackBar?
                }
                else{
                    Toast.makeText(LoginActivity.this, "Pleat Fill in Again", Toast.LENGTH_SHORT).show();

                }
            }
        });

        etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                validateEditEmail();
            }
        });

        etPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: add your Password validation here
                validateEditPass();
            }
        });


    }



    private boolean validateEditPass(){
        boolean isValidatedPass = true;
        if (etPassword.getText().toString().length() == 0) {
            etPassword.setError("Please Enter Password");
            isValidatedPass = false;
        }
        else if (etPassword != null && etPassword.length() < 6) {
            etPassword.setError("Must be at least 6 characters");
            isValidatedPass = false;
        }


        return isValidatedPass;
    }

    private boolean validateEditEmail(){
        boolean isValidatedEmail = true;


        if(!etEmail.getText().toString().trim().matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            etEmail.setError("Invalid Email");
            isValidatedEmail =false;
        }


        return isValidatedEmail;
    }



}
