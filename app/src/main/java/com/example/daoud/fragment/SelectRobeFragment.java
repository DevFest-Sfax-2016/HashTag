package com.example.daoud.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.daoud.adapter.RobeAdapter;
import com.example.daoud.model.Robe;
import com.example.daoud.wedding_dresses.R;
import com.example.daoud.task.SelectRobeTask;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SelectRobeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectRobeFragment extends Fragment {

    ListView listViewRobe;
    private ArrayList<Robe> data;
    private RobeAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    // TODO: Rename and change types of parameters
    private String mParam1;

    public SelectRobeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SelectRobeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectRobeFragment newInstance(String param1) {
        SelectRobeFragment fragment = new SelectRobeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_select_robe, container, false);
        //1
        listViewRobe= (ListView) rootView.findViewById(R.id.listViewRobe);
        data =new ArrayList<Robe>();

        new SelectRobeTask(getActivity(),data,listViewRobe).execute();

        return rootView;
    }
}
