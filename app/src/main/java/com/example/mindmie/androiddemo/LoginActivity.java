package com.example.mindmie.androiddemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private ProgressDialog progessDialog;
    private FirebaseAuth mAuth;

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
        progessDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
    }

    private void initView(){
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateEditEmail()&&validateEditPass()) {

                    loginUser();
                    //startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                    //Toast.makeText(LoginActivity.this, "Okay. You Login Complete.", Toast.LENGTH_SHORT).show();
                    // SnackBar?

                }
                else{
                    Toast.makeText(LoginActivity.this, "Pleat Fill in Again", Toast.LENGTH_SHORT).show();

                }
            }

            private void loginUser(){
                String emailUser = etEmail.getText().toString().trim();
                String passwordUser = etPassword.getText().toString().trim();

                progessDialog.setMessage("Connecting ...");
                progessDialog.show();

                mAuth.signInWithEmailAndPassword(emailUser,passwordUser)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {


                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            progessDialog.dismiss();
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        }
                        else {
                            progessDialog.dismiss();
                            updateUI(null);
                            Toast.makeText(LoginActivity.this, "Email or Password is wrong , please try again", Toast.LENGTH_SHORT).show();


                        }
                    }
                });

            }

            private void updateUI(FirebaseUser user) {
                if (user != null) {
                    Intent intent = new Intent( LoginActivity.this , ProfileActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } else {
                    return;
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
