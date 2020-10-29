package com.example.android.app.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.android.app.model.Topic;
import com.example.myapplication.R;

import java.util.List;

import model.Topic;

public class ThiThu extends ArrayAdapter<ThiThu> {
    private Activity activity;
    private int resource;
    private List<ThiThu> topic;

    public ThiThu(@NonNull Activity context, int resource, @NonNull List<ThiThu> topic) {
        super(context, resource, topic);
        this.activity = context;
        this.resource = resource;
        this.topic = topic;
    }

    @Override
    public int getCount() {
        if (topic == null){
            return 0;
        }
        return topic.size();
    }

    @Override
    public Topic getItem
}
