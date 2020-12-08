package com.example.nhom96.HomeActivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nhom96.PracticeFragment.PracticeAdapter;
import com.example.nhom96.PracticeFragment.datamodel;
import com.example.nhom96.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PracticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PracticeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<datamodel> dataholder;

    public PracticeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PracticeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PracticeFragment newInstance(String param1, String param2) {
        PracticeFragment fragment = new PracticeFragment();
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
        View v = inflater.inflate(R.layout.fragment_practice, container, false);

        recyclerView = v.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dataholder = new ArrayList<>();

        datamodel ob1 = new datamodel(R.drawable.public_chat_group);
        dataholder.add(ob1);

        datamodel ob2 = new datamodel(R.drawable.on_va_test);
        dataholder.add(ob2);

        datamodel ob3 = new datamodel(R.drawable.goc_luyen_tu_vung);
        dataholder.add(ob3);

        datamodel ob4 = new datamodel(R.drawable.nghe_audio_da_tai);
        dataholder.add(ob4);

        datamodel ob5 = new datamodel(R.drawable.audio_story_yeu_thich);
        dataholder.add(ob5);

        datamodel ob6 = new datamodel(R.drawable.mau_truyen_yeu_thich);
        dataholder.add(ob6);

        datamodel ob7 = new datamodel(R.drawable.file_ghi_am_cua_ban);
        dataholder.add(ob7);

        datamodel ob8 = new datamodel(R.drawable.ghi_chu_da_tao);
        dataholder.add(ob8);

        recyclerView.setAdapter(new PracticeAdapter(dataholder));

        return v;
    }
}