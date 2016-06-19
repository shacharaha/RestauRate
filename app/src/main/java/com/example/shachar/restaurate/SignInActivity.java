package com.example.shachar.restaurate;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shachar.restaurate.activity.MainActivity;
import com.example.shachar.resturate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import firebase.MyFireBaseDataBase;

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    EditText etEmail;
    EditText etPassword;
    Button btnSignUp;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etEmail = (EditText)findViewById(R.id.et_email);
        etPassword = (EditText)findViewById(R.id.et_password);
        btnSignUp = (Button)findViewById(R.id.btn_sign_up);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUserWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });

        btnSignIn = (Button)findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithEmailAndPassword(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });


        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    LogUtils.logFireBaseAuth("onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    LogUtils.logFireBaseAuth("onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    private void createUserWithEmailAndPassword(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        LogUtils.logFireBaseAuth( "createUserWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    private void signInWithEmailAndPassword(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        LogUtils.logFireBaseAuth("signInWithEmail:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            LogUtils.logFireBaseAuth("signInWithEmail " + task.getException());
                            //Log.w(TAG, "signInWithEmail", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            startMainActivity();
                        }
                        // ...
                    }
                });
    }
    private void signOut()
    {
        FirebaseAuth.getInstance().signOut();
    }
    private void startMainActivity()
    {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}
