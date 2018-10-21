package com.rosebuds.prasad.schoolproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NotificationAdapter extends ArrayAdapter<Meassage> {

    Context mCtx;
    int resId;
    List<Meassage> notifList;

    public NotificationAdapter(Context mCtx, int resId, List<Meassage> notifList){

        super(mCtx,resId,notifList);

        this.mCtx=mCtx;
        this.resId=resId;
        this.notifList=notifList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(resId,null);

        TextView textViewName= view.findViewById(R.id.tvNotification);

        Meassage employee = notifList.get(position);

        textViewName.setText(employee.getNotificationMessage());


        return view;

    }


}
