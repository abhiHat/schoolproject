package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TempNotification extends AppCompatActivity {

    private Intent intent;
    private String message;
    private TextView tempNotif;

    public static final String DATABASE_NAME="myNotifData";
    SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_notification);

        tempNotif = (TextView)findViewById(R.id.tempNotification);

        intent= getIntent();
        message=intent.getStringExtra("");

      //  mDatabase = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);

        createTable();
        addNoticeToTable(message);

        tempNotif.setText(message);

    }

    private void createTable(){

        String sql = "CREATE TABLE IF NOT EXISTS messages (\n" +
                " id INTEGER NOT NULL CONSTRAINT notif_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "msg varchar(500) NOT NULL)";
        mDatabase.execSQL(sql);
    }

    private void addNoticeToTable(String message){

        String sql = "INSERT INTO messages(msg)" +
                "VALUES (?)"
                ;
        mDatabase.execSQL(sql,new String [] {message});

        Toast.makeText(TempNotification.this,"Meassage saved "+sql, Toast.LENGTH_LONG).show();


    }


}
