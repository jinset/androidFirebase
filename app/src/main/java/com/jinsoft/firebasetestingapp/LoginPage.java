package com.jinsoft.firebasetestingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A login screen that offers login via email/password.
 */
public class LoginPage extends AppCompatActivity implements View.OnClickListener {

    Button signinButton,registerButton;
    EditText loginPassword, loginEmail;

    FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        signinButton = (Button)findViewById(R.id.signinButton);
        registerButton = (Button)findViewById(R.id.registerButton);
        loginPassword = findViewById(R.id.loginPassword);
        loginEmail = findViewById(R.id.loginEmail);

        signinButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    Log.i("sesion","inicia !!!" + user.getEmail());
                }else{
                    Log.i("sesion", "cerrada");
                }
            }
        };

    }

    private void register(){
        Intent myIntent = new Intent(LoginPage.this, RegisterPage.class);
        LoginPage.this.startActivity(myIntent);

        /*FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Log.i("sesion", "usuario creado correctamente");
                }else{
                    Log.i("sesion", "error a la hora de crear");
                }
            }
        });*/
    }

    private void login(String email, String password){
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password);
    }


    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.signinButton:
                String email = loginEmail.getText().toString();
                String password = loginPassword.getText().toString();
                login(email,password);
                break;

            case R.id.registerButton:
                register();
                break;
        }

    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        if (mAuthListener != null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }

    }


}

