package com.example.nestly;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import androidx.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SituationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SituationFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView callFriends;
    private TextView brokeStuff;
    private TextView cleanRoom;
    private TextView onNerves;
    private TextView dishes;
    private TextView badDay;

    private SharedPreferences myPrefs;

    public SituationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SituationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SituationFragment newInstance(String param1, String param2) {
        SituationFragment fragment = new SituationFragment();
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
        View v = inflater.inflate(R.layout.fragment_situation, container, false);

        Context context = getActivity();
        myPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        callFriends = v.findViewById(R.id.callFriends);
        brokeStuff = v.findViewById(R.id.brokeStuff);
        cleanRoom = v.findViewById(R.id.cleanRoom);
        onNerves = v.findViewById(R.id.onNerves);
        dishes = v.findViewById(R.id.dishes);
        badDay = v.findViewById(R.id.badDay);

        callFriends.setText(myPrefs.getString("situation1", ""));
        brokeStuff.setText(myPrefs.getString("situation2", ""));
        cleanRoom.setText(myPrefs.getString("situation3", ""));
        onNerves.setText(myPrefs.getString("situation4", ""));
        dishes.setText(myPrefs.getString("situation5", ""));
        badDay.setText(myPrefs.getString("situation6", ""));

        return v;
    }
}
