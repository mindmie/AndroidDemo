package com.example.mindmie.androiddemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisActivity extends AppCompatActivity  {

    private EditText etEmail;
    private EditText etPassword;
    private EditText etPassConfirm;
    private ProgressDialog progessDialog;

    // Authen by email& password
    private FirebaseAuth mAuth;

    // save user to database
     DatabaseReference databaseUser = FirebaseDatabase.getInstance().getReference();
        String key = databaseUser.push().getKey();






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
        progessDialog = new ProgressDialog(this);

        //firebase authen
        mAuth = FirebaseAuth.getInstance();


    }


    private void initView(){
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(validateEditEmail()&&validateEditPass()&&validateEditPassConfirm()) {
                    registerUser();

                }
                else{
                    Toast.makeText(RegisActivity.this, "Please Fill in Again", Toast.LENGTH_SHORT).show();
                }
            }


            private void registerUser(){
                final String emailUser = etEmail.getText().toString().trim();
                final String passwordUser = etPassword.getText().toString().trim();
                progessDialog.setMessage("Creating account ...");
                progessDialog.show();

                mAuth.createUserWithEmailAndPassword(emailUser,passwordUser)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                if (task.isSuccessful()){
                                    progessDialog.dismiss();
                                    FirebaseUser uuser = mAuth.getCurrentUser();
                                    updateUI(uuser);

                                    // push user n pwd to database
                                    databaseUser.child(key).child("username").child("E-mail").setValue(emailUser);
                                    databaseUser.child(key).child("username").child("Password").setValue(passwordUser);

                                    Toast.makeText(RegisActivity.this, "Registering complete", Toast.LENGTH_SHORT).show();

                                }
                                else{
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                        progessDialog.dismiss();
                                        Toast.makeText(getApplicationContext(),"This Account has already registered", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext() ,LoginActivity.class));


                                    }
                                    else{
                                        progessDialog.dismiss();
                                        updateUI(null);
                                        Toast.makeText(RegisActivity.this, "Registering was failed", Toast.LENGTH_SHORT).show();
                                    }



                                }
                            }
                        });

            }

            private void updateUI(FirebaseUser user) {
                if (user != null) {

                    Intent intent = new Intent( RegisActivity.this , Question1Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("key",key); // send key to next activity
                    startActivity(intent);

                } else {
                    return;
                }
            }
        }); //end of btn_register onClickListener





        //-------------------------------validation here
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
    } //end of init view

    //---------------validation function here


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
