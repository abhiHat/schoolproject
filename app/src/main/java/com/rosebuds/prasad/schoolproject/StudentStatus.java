package com.rosebuds.prasad.schoolproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.rosebuds.prasad.schoolproject.MyFirebaseMessagingService.DATABASE_NAME;

public class StudentStatus extends AppCompatActivity {

  //  private TextView notifcn;
    private Intent intent;
    private List<Meassage> notifList;
   // private ArrayAdapter arrayAdapter ;
   // private String msg;

    public static final String DATABASE_NAME="myNotifData";
    SQLiteDatabase mDatabase;

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_status);

       // notifcn = (TextView)findViewById(R.id.textView9);
       // intent= getIntent();
       //  msg=intent.getStringExtra("");
      // notifcn.setText(msg);

        listView = (ListView)findViewById(R.id.ListNotif);

        notifList = new ArrayList<>();
    /*    arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        arrayList.add(msg);
        arrayAdapter.notifyDataSetChanged();

*/


          mDatabase = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
      //  createTable();
      //  addEmp();
        fetchNotification();
    }

  /*  private void createTable(){

        String sql = "CREATE TABLE IF NOT EXISTS messages (\n" +
                " id INTEGER NOT NULL CONSTRAINT notif_pk PRIMARY KEY AUTOINCREMENT,\n" +
                "msg varchar(500) NOT NULL)";
        mDatabase.execSQL(sql);
    } */
/*
    private void addEmp(){

        String sql = "INSERT INTO messages(msg)" +
                "VALUES (?)"
                ;
        mDatabase.execSQL(sql,new String [] {msg});

        Toast.makeText(this,"Meassage saved ",Toast.LENGTH_LONG).show();


    }  */

  private void fetchNotification(){

        String sql = "SELECT * FROM messages";
        Cursor cursor = mDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                notifList.add(new Meassage(cursor.getInt(0),cursor.getString(1)));

            }while (cursor.moveToNext());

            NotificationAdapter adapter = new NotificationAdapter(StudentStatus.this,R.layout.list_notification_activity,notifList);
            listView.setAdapter(adapter);
        }
    }
}
