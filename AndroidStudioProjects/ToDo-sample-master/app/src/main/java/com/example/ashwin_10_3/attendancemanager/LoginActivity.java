package com.example.ashwin_10_3.attendancemanager;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    TextView emailID;
    TextView passwordLogin;
    Button signIn;
    TextView newUser;
    Spinner spinner;
    FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    RadioGroup radioGroup;
    RadioButton user,technician;
    public String typeOfUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null)
        {
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }
        emailID = findViewById(R.id.user_id);
        passwordLogin = findViewById(R.id.password_login_id);
        signIn = findViewById(R.id.signin_id);
        newUser = findViewById(R.id.new_id);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(passwordLogin.getText().toString().equals("")||emailID.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all details to proceed",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    signinHelper();
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
    }
    public void startRegisterActivity()
    {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
    public void startSelectActivity()
    {
        Intent intent = new Intent(this,NavActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Toast.makeText(this,"Sign in to proceed",Toast.LENGTH_SHORT).show();
    }
    public void signinHelper()
    {
        mAuth.signInWithEmailAndPassword(emailID.getText().toString(),passwordLogin.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"Successful!",
                                    Toast.LENGTH_SHORT).show();
                            startSelectActivity();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Failed to find user!",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}