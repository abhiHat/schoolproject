package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class ParentsProfile extends AppCompatActivity {

    private Button btnAboutUs,btnGallery,btnStuStat,btnParLogout;
    private Intent gotoAboutUs,gotoGallery,gotoStudStat,gotoParLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parents_profile);

        btnAboutUs=(Button)findViewById(R.id.btnAboutUs);
        btnGallery=(Button)findViewById(R.id.btnGallery);
        btnStuStat=(Button)findViewById(R.id.btnStuStat);
        btnParLogout=(Button)findViewById(R.id.btnParLogout);

        gotoAboutUs=new Intent(ParentsProfile.this,AboutUs.class);
        gotoGallery=new Intent(ParentsProfile.this,Gallery.class);
        gotoStudStat=new Intent(ParentsProfile.this,StudentStatus.class);
        gotoParLogin=new Intent(ParentsProfile.this,ParentsLogin.class);


        mAuth=FirebaseAuth.getInstance();

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoAboutUs);
            }
        });

        btnStuStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoStudStat);
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoGallery);
            }
        });

        btnParLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                finish();
                startActivity(gotoParLogin);
            }
        });



    }

}
