package com.minhduc.android.trieuphumobile;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.Random;

public class KhanGiaTroGiup extends Dialog {
    public KhanGiaTroGiup(@NonNull Context context, int vtD) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.khan_gia_tro_giup);
        TextView ykienA, ykienB, ykienC, ykienD;
        ykienA = findViewById(R.id.ykienA);
        ykienB = findViewById(R.id.ykienB);
        ykienC = findViewById(R.id.ykienC);
        ykienD = findViewById(R.id.ykienD);

        int arr[] = new int[] {0, 0, 0, 0};
        int blnc = 25;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + blnc;
            if (i == vtD-1) {
                arr[i] = arr[i]+25;
                blnc = blnc + 25;
            }
            blnc = blnc + 25;
        }

        int sum = 125;
        int arr1[] = new int[] {0, 0, 0, 0};
        int audience = 200;
        Random r = new Random();
        for (int i = 0; i < audience; i++) {
            int select = r.nextInt(sum);
            if (select >= 0 && select < arr[0]) {
                arr1[0]++;
            } else if (select >= arr[0] && select < arr[1]) {
                arr1[1]++;
            } else if (select >= arr[1] && select < arr[2]) {
                arr1[2]++;
            } else {
                arr1[3]++;
            }
        }

        ykienA.setText("A : " + (int)arr1[0]*100.0f/audience + " %");
        ykienB.setText("A : " + (int)arr1[1]*100.0f/audience + " %");
        ykienC.setText("A : " + (int)arr1[2]*100.0f/audience + " %");
        ykienD.setText("A : " + (int)arr1[3]*100.0f/audience + " %");
    }
}
