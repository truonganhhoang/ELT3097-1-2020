package com.example.duoihinhbatchu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import com.example.duoihinhbatchu.adapter.DapAnAdapter;

import java.util.ArrayList;
import java.util.Random;

public class Main2activity extends AppCompatActivity {

    private String Dapan = "baocao";
    ArrayList<String> arrayCauTraLoi;
    GridView gdvCauTraLoi;
    int index=0;
    ArrayList<String> arrayDapan;
    GridView gdvDapan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batdau);
        init();
        anhXa();
        setOnClick();
        bamData();
        hienThiCauTraLoi();
        hienThiDapan();
        checkWin();
    }

    private void anhXa() {
        gdvCauTraLoi = findViewById(R.id.gdvCauTraLoi);
        gdvDapan = findViewById(R.id.gdvDapan);
    }

    private void init() {
        arrayCauTraLoi = new ArrayList<>();

        arrayDapan = new ArrayList<>();
    }

    private void hienThiCauTraLoi() {
        gdvCauTraLoi.setNumColumns(arrayCauTraLoi.size());
        gdvCauTraLoi.setAdapter(new DapAnAdapter(this, 0, arrayCauTraLoi));

    }

    private void hienThiDapan() {
        gdvDapan.setNumColumns(arrayDapan.size() / 2);
        gdvDapan.setAdapter(new DapAnAdapter(this, 0, arrayDapan));
    }

    private void setOnClick(){
        gdvDapan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= (String) parent.getItemAtPosition(position);
                if(s.length()!=0 && index< arrayCauTraLoi.size()){
                    for(int i=0; i<arrayCauTraLoi.size();i++){
                        if(arrayCauTraLoi.get(i).length()==0){
                            index = i;
                            break;
                        }
                    }
                    arrayDapan.set(position,"");
                    arrayCauTraLoi.set(index,s);
                    index++;
                    hienThiCauTraLoi();
                    hienThiDapan();
                }
            }
        });
        gdvCauTraLoi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s= (String) parent.getItemAtPosition(position);
                if(s.length()!=0 ){
                    index = position;
                    arrayCauTraLoi.set(position,"");
                    for(int i=0;i<arrayDapan.size();i++){
                        if(arrayDapan.get(i).length()==0){
                            arrayDapan.set(i,s);
                            break;
                        }
                        hienThiCauTraLoi();
                        hienThiDapan();
                    }
                }
            }
        });
    }
    private void bamData() {
        arrayCauTraLoi.clear();
        Random r = new Random();
        for (int i = 0; i < Dapan.length(); i++) {
            arrayCauTraLoi.add("");
            String s = "" + (char) (r.nextInt(26) + 65);
            arrayDapan.add(s);
            String s1 = "" + (char) (r.nextInt(26) + 65);
            arrayDapan.add(s1);
        }   
        for (int i = 0; i < Dapan.length(); i++) {
            String s=""+ Dapan.charAt(i);
            arrayDapan.set(i,s.toUpperCase());
        }
        for (int i=0; i<10; i++){
            String s= arrayDapan.get(i);
            int vt= r.nextInt(arrayDapan.size());
            arrayDapan.set(i,arrayDapan.get(vt));
            arrayDapan.set(vt,s);
        }
    }

    private void checkWin(){
        String s="";
        for (String s1:arrayCauTraLoi){
            s=s+s1;
        }
        s=s.toUpperCase();
        if(s.equals(Dapan.toUpperCase())){
            Toast.makeText(this, "Ban Da Chien Thang",Toast.LENGTH_SHORT).show();
        }
    }
}