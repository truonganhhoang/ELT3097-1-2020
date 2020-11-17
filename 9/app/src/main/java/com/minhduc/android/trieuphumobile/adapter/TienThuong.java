package com.minhduc.android.trieuphumobile.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.minhduc.android.trieuphumobile.R;

import java.util.ArrayList;
import java.util.List;

public class TienThuong extends ArrayAdapter<String> {
    Context mct;
    ArrayList<String> arr;

    public TienThuong(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.mct = context;
        this.arr = new ArrayList<>(objects);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)mct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tien_thuong, null);
        }
        if (arr.size() > 0) {
            int pos = 15 - position;
            TextView textTienThuong = convertView.findViewById(R.id.textTienThuong);
            if (pos%5 == 0) {
                textTienThuong.setTextColor(Color.parseColor("#FF9800"));
            }else {
                textTienThuong.setTextColor(Color.parseColor("#FFFFFF"));
            }
            String textHienThi = pos + "   " + arr.get(position);
            textTienThuong.setText(textHienThi);
        }
        return convertView;
    }
}
