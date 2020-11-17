package com.minhduc.android.trieuphumobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.minhduc.android.trieuphumobile.adapter.TienThuong;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
ListView lsvTienThuong;
TienThuong TienThuongAdapter;
ArrayList<String> arrTienThuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        AnhXa();
        setUp();
        setClick();
    }

    public void init() {
        arrTienThuong = new ArrayList<>();
        arrTienThuong.add("150,000,000");
        arrTienThuong.add("85,000,000");
        arrTienThuong.add("60,000,000");
        arrTienThuong.add("40,000,000");
        arrTienThuong.add("30,000,000");
        arrTienThuong.add("22,000,000");
        arrTienThuong.add("14,000,000");
        arrTienThuong.add("10,000,000");
        arrTienThuong.add("6,000,000");
        arrTienThuong.add("3,000,000");
        arrTienThuong.add("2,000,000");
        arrTienThuong.add("1,000,000");
        arrTienThuong.add("600,000");
        arrTienThuong.add("400,000");
        arrTienThuong.add("200,000");

        TienThuongAdapter = new TienThuong(this, 0, arrTienThuong);
    }

    public void AnhXa() {
        lsvTienThuong = findViewById(R.id.lsvTienThuong);
    }

    public void setUp() {
        lsvTienThuong.setAdapter(TienThuongAdapter);
    }

    public void setClick() {

    }
}