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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
public class AdminLogin extends AppCompatActivity {

    private Button btnAdmnLog;
    private EditText edtAdmnUname,adtTaxtAdmnPass;
    private Intent goToAdmnProf;
    int flag=0;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        goToAdmnProf=new Intent(AdminLogin.this,AdminProfile.class);


        btnAdmnLog=(Button)findViewById(R.id.btnAdmnLog);
        edtAdmnUname=(EditText)findViewById(R.id.edtTxtAdmUname);
        adtTaxtAdmnPass=(EditText)findViewById(R.id.edtTxtadmnPass);

        mAuth=FirebaseAuth.getInstance();
        progressBar=(ProgressBar)findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.GONE);

        btnAdmnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adminVeriFy();
                //login();
            }
        });
    }

    public void login(){

        String email=edtAdmnUname.getText().toString();
        String Password = adtTaxtAdmnPass.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(AdminLogin.this,"Plaese enter the email/username.",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(Password)){

            Toast.makeText(AdminLogin.this,"Plaese enter the password.",Toast.LENGTH_SHORT).show();
        }else{

            mAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(AdminLogin.this,"Login Successfully",Toast.LENGTH_SHORT).show();
                        startActivity(goToAdmnProf);
                    }
                    else {
                        Toast.makeText(AdminLogin.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    public void adminVeriFy(){

        String adId=edtAdmnUname.getText().toString();

        ArrayList<String> adminId = new ArrayList<>();
        adminId.add("arvindjadhav23@gmail.com");
        adminId.add("pravinpandey72@gmail.com");


        for (int i = 0; i < adminId.size() ; i++) {
            if(adminId.get(i).equals(adId))
                {
                    flag=1;
                }
        }
        if (flag==1){
            login();

        }
        else
        {
            Toast.makeText(AdminLogin.this,"You are not authorised to login as Admin.",Toast.LENGTH_SHORT).show();
        }
    }}
