package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class AdminProfile extends AppCompatActivity {

    private Button btnAddPrnt,btnSeeAttndnc,btnlogout;
    private Intent goToAddParent,goToSeeAttndnc,gotoLogin;
    private FirebaseAuth mAuth;
    //   private DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_profile);

        btnAddPrnt=(Button)findViewById(R.id.btnAdParent);
      //  btnAddtchr=(Button)findViewById(R.id.btnAddTeacher);
        btnSeeAttndnc=(Button)findViewById(R.id.btnSeeAtdnc);
        btnlogout=(Button)findViewById(R.id.btnAdmnLogOut);

        goToAddParent=new Intent(AdminProfile.this,Add_Parent.class);
      //  goToAddTeacher=new Intent(AdminProfile.this,AddTeacher.class);
        goToSeeAttndnc=new Intent(AdminProfile.this,See_Attendence.class);
        gotoLogin = new Intent(AdminProfile.this,AdminLogin.class);

        mAuth=FirebaseAuth.getInstance();
        // mRef=FirebaseDatabase.getInstance().getReference();


        btnAddPrnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToAddParent);
            }
        });

        

        btnSeeAttndnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToSeeAttndnc);
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                finish();
                startActivity(gotoLogin);

            }
        });

    }
}
