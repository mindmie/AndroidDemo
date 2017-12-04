package com.example.mindmie.androiddemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPassConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);
        bindView();
        initView();
    }

    private void bindView(){

        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pwd);
        etPassConfirm = (EditText) findViewById(R.id.et_confirmPwd);
    }

    private void initView(){
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditEmail()) {
                    startActivity(new Intent(getApplicationContext(),Question1Activity.class));
                    Toast.makeText(RegisActivity.this, "Okay. Create Your Account Complete.", Toast.LENGTH_SHORT).show();
                    // SnackBar?

                }
                else{
                    Toast.makeText(RegisActivity.this, "Pleat Fill in Again", Toast.LENGTH_SHORT).show();

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
        etPassConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO: add your Password validation here
                validateEditPassConfirm();
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

    private boolean validateEditPassConfirm(){
        boolean isValidatedPassConfirm = true;
        if (etPassConfirm.getText().toString().length() == 0) {
            etPassConfirm.setError("Please Enter Password");
            isValidatedPassConfirm = false;
        }
        if (!etPassConfirm.getText().toString().trim().matches(etPassword.getText().toString()) ) {
            etPassConfirm.setError("Password not Correct!!!");
            isValidatedPassConfirm = false;
        }

        return isValidatedPassConfirm;
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
