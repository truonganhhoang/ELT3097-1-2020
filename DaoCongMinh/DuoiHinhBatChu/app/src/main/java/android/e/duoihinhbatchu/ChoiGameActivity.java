package android.e.duoihinhbatchu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;

import adapter.DapAnAdapter;

public class ChoiGameActivity extends AppCompatActivity {

    ArrayList<String> arrCauTraLoi;
    GridView gdvCauTraLoi;

    ArrayList<String> arrDapAn;
    GridView gdvDapAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choi_game);
        init();
        anhXa();
        hienThiCauTraLoi();
        hienThiDapAn();
    }

    private void anhXa(){
        gdvCauTraLoi = findViewById(R.id.gdvCauTraLoi);
        gdvDapAn = findViewById(R.id.gdvDapAn);
    }

    private void init(){
        arrCauTraLoi = new ArrayList<>();
        arrCauTraLoi.add("B");
        arrCauTraLoi.add("B");
        arrCauTraLoi.add("B");
        arrCauTraLoi.add("B");
        arrCauTraLoi.add("B");

        arrDapAn = new ArrayList<>();
        arrDapAn.add("M");
        arrDapAn.add("O");
        arrDapAn.add("I");
        arrDapAn.add("A");
        arrDapAn.add("U");
        arrDapAn.add("W");
        arrDapAn.add("G");
        arrDapAn.add("D");
    }

    private void hienThiCauTraLoi(){
        gdvCauTraLoi.setNumColumns(arrCauTraLoi.size());
        gdvCauTraLoi.setAdapter(new DapAnAdapter(this, 0, arrCauTraLoi));
    }

    private void hienThiDapAn(){
        gdvDapAn.setNumColumns(arrDapAn.size()/2);
        gdvDapAn.setAdapter(new DapAnAdapter(this, 0, arrDapAn));
    }
}