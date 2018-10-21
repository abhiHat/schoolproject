package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class TeacherProfile extends AppCompatActivity {

    private Button btnAddStud,btnStuAttndnc,btnTchrLogOut;
    private Intent goToTakeAttndnc,goToAddStudent,goToTchrLogin;
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        //  getActionBar().setTitle("Teachers Activity");

        btnAddStud=(Button)findViewById(R.id.btnAddStud);
        btnStuAttndnc=(Button)findViewById(R.id.btnTakeAttndnc);
        btnTchrLogOut=(Button)findViewById(R.id.btnTchrLogOut);

        goToTakeAttndnc=new Intent(TeacherProfile.this, Student_Attendence.class);
        goToAddStudent=new Intent(TeacherProfile.this,Add_Student.class);
        goToTchrLogin=new Intent(TeacherProfile.this, TeacherLogin.class);

        mAuth=FirebaseAuth.getInstance();

        btnTchrLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        btnAddStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToAddStudent);
            }
        });

        btnStuAttndnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToTakeAttndnc);
            }
        });
    }

    public void signOut(){
        mAuth.signOut();
        Toast.makeText(TeacherProfile.this,"You are signed out successfully..",Toast.LENGTH_LONG).show();
        startActivity(goToTchrLogin);
        finish();
    }

}
