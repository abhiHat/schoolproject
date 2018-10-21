package com.rosebuds.prasad.schoolproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Parent extends AppCompatActivity {

    private EditText Prntname,PrntEmail,PrntPhone,PrntStudId;
    private Button btnAddPrnt;
    private DatabaseReference mPrntDB;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__parent);

        Prntname=(EditText)findViewById(R.id.editParRegName);
        PrntEmail=(EditText)findViewById(R.id.editTextAddprntEmail);
        PrntPhone=(EditText)findViewById(R.id.editTextAddprntPnm);
        PrntStudId=(EditText)findViewById(R.id.editTextAddprntID);

        btnAddPrnt=(Button)findViewById(R.id.btnAddprbtAddPrnt);

        progressBar=(ProgressBar)findViewById(R.id.progressBar5);
        progressBar.setVisibility(View.GONE);

        mPrntDB= FirebaseDatabase.getInstance().getReference("Parents");

        btnAddPrnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addParent();
            }
        });
    }

    public void addParent(){

        String ParName=Prntname.getText().toString();
        String ParEmail=PrntEmail.getText().toString();
        String ParPhone=PrntPhone.getText().toString();
        String ParStudId=PrntStudId.getText().toString();

        if (TextUtils.isEmpty(ParName)){
            Prntname.setError("Name required");
            Prntname.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(ParEmail)){
            PrntEmail.setError("Email required");
            PrntEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(ParEmail).matches()){
            PrntEmail.setError("Enter valid Email");
            PrntEmail.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(ParPhone)){
            PrntPhone.setError("Phone number required");
            PrntPhone.requestFocus();
            return;
        }
        if (ParPhone.length() != 10){
            PrntPhone.setError("Enter valid phone number");
            PrntPhone.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(ParStudId)){
            PrntStudId.setError("Student's Id required");
            PrntStudId.requestFocus();
            return;
        }

        Parents parents = new Parents(ParName,ParEmail,ParPhone,ParStudId);

        progressBar.setVisibility(View.VISIBLE);

        String uid=mPrntDB.push().getKey();

        mPrntDB.child(uid).setValue(parents)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()){
                            Toast.makeText(Add_Parent.this,"Parent Added Successfully",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(Add_Parent.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
