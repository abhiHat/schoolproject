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

import java.util.ArrayList;

public class TeacherLogin extends AppCompatActivity {



    private TextView textViewAdm,tForPass;
    private Intent goToAdmLog,goToTprofile;
    private Button tLogbtn;
    private EditText tuname,tPass;
    private ProgressBar progressBar;
    private int flag=0;


    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        mAuth = FirebaseAuth.getInstance();

        textViewAdm=(TextView)findViewById(R.id.textViewAdm);
        tForPass=(TextView)findViewById(R.id.TeaLogTxtFP);

        tLogbtn=(Button)findViewById(R.id.TeaLogBtnLogin);
        tuname=(EditText)findViewById(R.id.TeaLogUname);
        tPass=(EditText)findViewById(R.id.TeaLogUpass);




        goToAdmLog=new Intent(this,AdminLogin.class);
        goToTprofile=new Intent(this,TeacherProfile.class);

        progressBar=(ProgressBar)findViewById(R.id.TprogressBar);

        progressBar.setVisibility(View.GONE);

        tForPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tempMail=tuname.getText().toString().trim();
                if (TextUtils.isEmpty(tempMail)){
                    Toast.makeText(TeacherLogin.this,"Please enter the email",Toast.LENGTH_LONG).show();
                }
                else {mAuth.sendPasswordResetEmail(tempMail);
                    Toast.makeText(TeacherLogin.this,"Please check your email",Toast.LENGTH_LONG).show();
                }

            }
        });



        tLogbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTeacherId();
                //     Login();
            }
        });

        textViewAdm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(goToAdmLog);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){

            startActivity(goToTprofile);
        }

    }

    public void Login(){

        String email,Pass;
        email=tuname.getText().toString();
        Pass=tPass.getText().toString();

        if (TextUtils.isEmpty(email)){

            Toast.makeText(TeacherLogin.this,"Please enter the username.",Toast.LENGTH_LONG).show();
        }else {
            if (TextUtils.isEmpty(Pass)){
                Toast.makeText(TeacherLogin.this,"Please enter the Password.",Toast.LENGTH_LONG).show();

            }else {


                progressBar.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,Pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                progressBar.setVisibility(View.GONE);
                                if (task.isSuccessful()){

                                    startActivity(goToTprofile);
                                    Toast.makeText(TeacherLogin.this,"Login Successfully..",Toast.LENGTH_LONG).show();
                                }else {

                                    Toast.makeText(TeacherLogin.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                                }

                            }
                        });

            }
        }


    }


    public void checkTeacherId(){

        String tempUname=tuname.getText().toString();

        //  String[] teacherId = {"arvindjadhav23@gmail.com","skamblesunita1976@gmail.com","vandanaparbat@gmail.com","sujatagavhane823@gmail.com","devayanipatil1974@gmail.com"
        //          ,"ranjeetabagate1984@gmail.com","SwatiWattamwar5945@gmail.com","shrawanpawar123@gmail.com","subhadradhadge1976@gmail.com"
        //  ,"monaligawali1992@gmail.com","dheerajkokane@gmail.com","kalpanakasture1981@gmail.com","vaishnav.lata76@gmail.com","pravinpandey72@gmail.com"
        //  ,"anu_023smore@rediffmail.com","anjuhooda91@gmail.com","diksha.aurangabad@gmail.com","ramesh.wnw@gmail.com","ashwiniatnoorkar@gmail.com"
        //  ,"sourabhgosavi9544@gmail.com","ashokmane98@gmail.com","varsha@divyacomputers.com","manishabharti@gmail.com","srushti.chandrika2@gmail.com"
        //  ,"neelam.shinde@gmail.com","praptigade1414@gmail.com","sarikadeshpande60@gmail.com","kanwateangad1981@gmail.com","aafzal91@gmail.com","rani.dengale@gmail.com"
        //  ,"more.amrita313@gmail.com","sakhareseema77@gmail.com","vishnugayakwad@gmail.com","manjushapathare403@gmail.com","pramodpagare458@gmail.com"};



        ArrayList<String> teacherId = new ArrayList<>();

        teacherId.add("arvindjadhav23@gmail.com");
        teacherId.add("skamblesunita1976@gmail.com");
        teacherId.add("vandanaparbat@gmail.com");
        teacherId.add("sujatagavhane823@gmail.com");
        teacherId.add("devayanipatil1974@gmail.com");
        teacherId.add("ranjeetabagate1984@gmail.com");
        teacherId.add("SwatiWattamwar5945@gmail.com");
        teacherId.add("shrawanpawar123@gmail.com");
        teacherId.add("subhadradhadge1976@gmail.com");
        teacherId.add("monaligawali1992@gmail.com");
        teacherId.add("dheerajkokane@gmail.com");
        teacherId.add("kalpanakasture1981@gmail.com");
        teacherId.add("vaishnav.lata76@gmail.com");
        teacherId.add("pravinpandey72@gmail.com");
        teacherId.add("anu_023smore@rediffmail.com");
        teacherId.add("anjuhooda91@gmail.com");
        teacherId.add("diksha.aurangabad@gmail.com");
        teacherId.add("ramesh.wnw@gmail.com");
        teacherId.add("ashwiniatnoorkar@gmail.com");
        teacherId.add("sourabhgosavi9544@gmail.com");
        teacherId.add("ashokmane98@gmail.com");
        teacherId.add("varsha@divyacomputers.com");
        teacherId.add("manishabharti@gmail.com");
        teacherId.add("srushti.chandrika2@gmail.com");
        teacherId.add("neelam.shinde@gmail.com");
        teacherId.add("praptigade1414@gmail.com");
        teacherId.add("sarikadeshpande60@gmail.com");
        teacherId.add("kanwateangad1981@gmail.com");
        teacherId.add("aafzal91@gmail.com");
        teacherId.add("rani.dengale@gmail.com");
        teacherId.add("more.amrita313@gmail.com");
        teacherId.add("sakhareseema77@gmail.com");
        teacherId.add("vishnugayakwad@gmail.com");
        teacherId.add("manjushapathare403@gmail.com");
        teacherId.add("pramodpagare458@gmail.com");

        for (int i = 0; i<teacherId.size(); i++) {
            if(teacherId.get(i).equals(tempUname))
            {
                flag=1;
            }
        }
        if (flag==1){
            Login();

        }
        else
        {
            Toast.makeText(TeacherLogin.this,"You are not authorised to login as teacher.",Toast.LENGTH_SHORT).show();
        }

    }
}
