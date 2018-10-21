package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class ParentsLogin extends AppCompatActivity {

    private EditText ParUname,ParUpass;
    private Button ParBtnLogin;
    private TextView TxtViewFP;
    private Intent gotoParentProfile;
    private ProgressBar mProgress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_login);

        ParUname = (EditText)findViewById(R.id.ParLogUname);
        ParUpass = (EditText)findViewById(R.id.ParLogUpass);
        TxtViewFP = (TextView) findViewById(R.id.ParLogTxtFP);
        ParBtnLogin = (Button)findViewById(R.id.PaLogBtnLogin);

        mProgress = (ProgressBar)findViewById(R.id.PBParLog);
        mProgress.setVisibility(View.GONE);

        gotoParentProfile = new Intent(ParentsLogin.this,ParentsProfile.class);

        mAuth = FirebaseAuth.getInstance();

        ParBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        TxtViewFP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ParUname.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(ParentsLogin.this,"Enter email please.",Toast.LENGTH_LONG).show();
                }else {

                    mAuth.sendPasswordResetEmail(ParUname.getText().toString());
                    Toast.makeText(ParentsLogin.this,"Plaese check the email fo resetting password.",Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            startActivity(gotoParentProfile);
        }

    }

    public void login(){

        String email = ParUname.getText().toString();
        String pass = ParUpass.getText().toString();



        if (TextUtils.isEmpty(email)){

            Toast.makeText(this,"Enter the user name",Toast.LENGTH_LONG).show();
        }else if (TextUtils.isEmpty(pass)){
            Toast.makeText(this,"Enter the password",Toast.LENGTH_LONG).show();
        }else {
            mProgress.setVisibility(View.VISIBLE);
            mAuth.signInWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            mProgress.setVisibility(View.GONE);
                            if (task.isSuccessful()){

                                Toast.makeText(ParentsLogin.this,"Login Successfully",Toast.LENGTH_LONG).show();
                                startActivity(gotoParentProfile);

                            }
                            else {
                                Toast.makeText(ParentsLogin.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }

                        }
                    });

        }
    }
}
