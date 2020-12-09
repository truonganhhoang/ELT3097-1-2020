package com.example.nhom96.HomeActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhom96.HomeFragment.HomeAdapter;
import com.example.nhom96.HomeFragment.datamodel;
import com.example.nhom96.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = v.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataholder = new ArrayList<>();

        datamodel ob1 = new datamodel(R.drawable.book, "Nhật kí chinh phục English");
        dataholder.add(ob1);

        datamodel ob2 = new datamodel(R.drawable.news, "Báo song ngữ");
        dataholder.add(ob2);

        datamodel ob3 = new datamodel(R.drawable.tai_nghe, "Truyện ngắn (có audio)");
        dataholder.add(ob3);

        datamodel ob4 = new datamodel(R.drawable.open_book, "Truyện ngắn");
        dataholder.add(ob4);

        datamodel ob5 = new datamodel(R.drawable.mat_cuoi, "Truyện cười");
        dataholder.add(ob5);

        datamodel ob6 = new datamodel(R.drawable.mau_cau, "Mẫu Câu thông dụng");
        dataholder.add(ob6);

        datamodel ob7 = new datamodel(R.drawable.danh_ngon, "Các câu danh ngôn");
        dataholder.add(ob7);

        datamodel ob8 = new datamodel(R.drawable.kien_thuc, "Kiến thức tổng hợp");
        dataholder.add(ob8);

        datamodel ob9 = new datamodel(R.drawable.co_tich, "Truyện cổ tích");
        dataholder.add(ob9);

        datamodel ob10 = new datamodel(R.drawable.ngu_ngon, "Truyện ngụ ngôn");
        dataholder.add(ob10);

        datamodel ob11 = new datamodel(R.drawable.bai_luan, "Bài luận mẫu");
        dataholder.add(ob11);

        datamodel ob12 = new datamodel(R.drawable.cambridge, "CambridgeIELTS");
        dataholder.add(ob12);

        recyclerView.setAdapter(new HomeAdapter(dataholder));

        return v;
    }
}