package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class customAdapter extends ArrayAdapter {
    Activity activity;
    int layout;
    ArrayList <sinhvien> arrSinhVien;

    public customAdapter(@NonNull Activity activity, int layout, @NonNull ArrayList<sinhvien> arrSinhVien) {
        super(activity, layout, arrSinhVien);

        this.activity = activity ;
        this.layout = layout ;
        this.arrSinhVien = arrSinhVien;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        convertView = layoutInflater.inflate(layout, null);

        ImageView avatar = (ImageView) convertView.findViewById(R.id.avatar);
        TextView ten = (TextView) convertView.findViewById(R.id.text_ten);
        TextView sdt = (TextView) convertView.findViewById(R.id.text_sdt);

        avatar.setImageResource(arrSinhVien.get(position).getAvatar());
        ten.setText(arrSinhVien.get(position).getTenSinhVien());
        sdt.setText(arrSinhVien.get(position).getSdtSinhVien());

        return convertView;
    }
}
