package com.rosebuds.prasad.schoolproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Student extends AppCompatActivity {

    private EditText studName,studId;
    private Spinner board,studClass;
    private Button addStud;
    private ProgressBar progressBar;
    private DatabaseReference mDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__student);

        studName=(EditText)findViewById(R.id.studName);
        studClass=(Spinner)findViewById(R.id.studClass);
        studId=(EditText)findViewById(R.id.studId);
        board=(Spinner)findViewById(R.id.board);
        addStud=(Button)findViewById(R.id.addStud);

        progressBar=(ProgressBar)findViewById(R.id.progressBar2);
        progressBar.setVisibility(View.GONE);

        addStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewStudent();

            }
        });
    }

    public void addNewStudent(){


        String name=studName.getText().toString();
        String sClass=studClass.getSelectedItem().toString();
        String id=studId.getText().toString();
        String sBoard=board.getSelectedItem().toString();
        progressBar.setVisibility(View.VISIBLE);

        mDatabase= FirebaseDatabase.getInstance().getReference("students")
                .child(sBoard).child(sClass);

        StudentAdd studentAdd=new StudentAdd(name,sBoard,id,sClass);

        String uid=mDatabase.push().getKey();


        mDatabase.child(uid).setValue(studentAdd).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()){

                    Toast.makeText(Add_Student.this,"Student Added Successfully",Toast.LENGTH_LONG).show();



                }else {
                    Toast.makeText(Add_Student.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
