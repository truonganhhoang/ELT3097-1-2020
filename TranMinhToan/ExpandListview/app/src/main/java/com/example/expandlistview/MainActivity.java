package com.example.expandlistview;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;

    private ExpandableListViewAdapter expandableListViewAdapter;

    private List<String> listDataGroup;

    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initViews();

        initListeners();

        initObjects();

        initListData();
    }

    private void initViews() {

        expandableListView = findViewById(R.id.expandableListView);
    }

    private void initListeners() {

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        listDataGroup.get(groupPosition) + " : " + listDataChild.get(listDataGroup.get(groupPosition)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void initObjects() {

        listDataGroup = new ArrayList<>();

        listDataChild = new HashMap<>();

        expandableListViewAdapter = new ExpandableListViewAdapter(this, listDataGroup, listDataChild);

        expandableListView.setAdapter(expandableListViewAdapter);
    }

    private void initListData() {

        // Adding group data
        listDataGroup.add(getString(R.string.header_1));
        listDataGroup.add(getString(R.string.truyen_ngan_1_1));
        listDataGroup.add(getString(R.string.truyen_ngan_1_2));
        listDataGroup.add(getString(R.string.truyen_ngan_1_3));
        listDataGroup.add(getString(R.string.truyen_ngan_1_4));
        listDataGroup.add(getString(R.string.truyen_ngan_1_5));

        // array of strings
        String[] array;

        // list of alcohol
        List<String> truyen_ngan_1_1_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.truyen_ngan_1_1_dich);
        for (String item : array) {truyen_ngan_1_1_List.add(item);}

        List<String> truyen_ngan_1_2_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.truyen_ngan_1_2_dich);
        for (String item : array) {truyen_ngan_1_2_List.add(item);}

        List<String> truyen_ngan_1_3_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.truyen_ngan_1_3_dich);
        for (String item : array) {truyen_ngan_1_3_List.add(item);}

        List<String> truyen_ngan_1_4_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.truyen_ngan_1_4_dich);
        for (String item : array) {truyen_ngan_1_4_List.add(item);}

        List<String> truyen_ngan_1_5_List = new ArrayList<>();
        array = getResources().getStringArray(R.array.truyen_ngan_1_5_dich);
        for (String item : array) {truyen_ngan_1_5_List.add(item);}

            // Adding child datata
            listDataChild.put(listDataGroup.get(0), null);
            listDataChild.put(listDataGroup.get(1), truyen_ngan_1_1_List);
            listDataChild.put(listDataGroup.get(2), truyen_ngan_1_2_List);
            listDataChild.put(listDataGroup.get(3), truyen_ngan_1_3_List);
            listDataChild.put(listDataGroup.get(4), truyen_ngan_1_4_List);
            listDataChild.put(listDataGroup.get(5), truyen_ngan_1_5_List);

            // notify the adapter
            expandableListViewAdapter.notifyDataSetChanged();
    }
}