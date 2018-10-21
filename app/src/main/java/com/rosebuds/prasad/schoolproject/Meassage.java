package com.rosebuds.prasad.schoolproject;

public class Meassage {
    int id;
    String notificationMessage;

    public Meassage(int id,String notificationMessage) {

        this.id=id;
        this.notificationMessage = notificationMessage;
    }

    public int getId(){
        return id;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }


}
