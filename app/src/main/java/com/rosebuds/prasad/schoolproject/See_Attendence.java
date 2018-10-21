package com.rosebuds.prasad.schoolproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class See_Attendence extends AppCompatActivity {

    private Button sendNotice;
    private EditText txtNotice;
 //   DatabaseReference mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see__attendence);

        sendNotice = (Button)findViewById(R.id.sendNotice);
        txtNotice = (EditText)findViewById(R.id.txtNotice);

     /*   mRef = FirebaseDatabase.getInstance().getReference("Notice");

        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotice();
            }
        }); */

    }

   /* public void addNotice(){

        String Notice = txtNotice.getText().toString().trim();
        if (TextUtils.isEmpty(Notice)){
            Toast.makeText(this,"Enter the notice first..",Toast.LENGTH_LONG).show();
        }else {

            Meassage message = new Meassage(Notice);
            mRef.setValue(message).
                    addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(See_Attendence.this,"Notice Sent Successfully",Toast.LENGTH_LONG).show();
                                finish();
                                System.exit(0);
                            }else {
                                Toast.makeText(See_Attendence.this,task.getException().toString(),Toast.LENGTH_LONG).show();
                            }
                        }
                    });

        }



    } */


}
