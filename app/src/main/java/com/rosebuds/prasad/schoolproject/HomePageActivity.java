package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private Button btnParLog,btnTecherLog,btnVisitor;
    private Intent gotoParLogin,gotoTacherLogin,gotoVisitorProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        btnParLog = (Button)findViewById(R.id.HomePageParLog);
        btnTecherLog = (Button) findViewById(R.id.HomePageTeaLog) ;
        btnVisitor = (Button)findViewById(R.id.HomePageVisitor);

        gotoParLogin = new Intent(this,ParentsLogin.class);
        gotoTacherLogin = new Intent(this,TeacherLogin.class);
        gotoVisitorProfile = new Intent(this,VisitorProfile.class);

        btnParLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoParLogin);
            }
        });

        btnTecherLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoTacherLogin);
            }
        });

        btnVisitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(gotoVisitorProfile);
            }
        });
    }
}
