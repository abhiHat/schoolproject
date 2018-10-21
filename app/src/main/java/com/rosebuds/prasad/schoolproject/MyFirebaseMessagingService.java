package com.rosebuds.prasad.schoolproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String DATABASE_NAME="myNotifData";
    SQLiteDatabase mDatabase;



    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        showNotification(remoteMessage.getNotification().getBody());
    }

    public void showNotification(String message){

        Intent i= new Intent(this,StudentStatus.class);

       // i.putExtra("",message);
        PendingIntent pi = PendingIntent.getActivity(this,0,i,0);

        Notification notification = new Notification.Builder(this)
                .setSmallIcon(R.drawable.logo1)
                .setContentTitle("Rose Buds English School")
                .setContentText(message)
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();

        NotificationManager notificationManager= (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);

        mDatabase = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE,null);
        createTable();
        addNoticeToTable(message);

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

        Toast.makeText(MyFirebaseMessagingService.this,"Meassage saved "+sql, Toast.LENGTH_LONG).show();


    }


}
