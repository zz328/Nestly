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
 * Use the {@link LongAnswerFragmentUser#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LongAnswerFragmentUser extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView typicalDay;
    private TextView worstHabit;
    private TextView hopeRoommate;
    private TextView other;

    public LongAnswerFragmentUser() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LongAnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LongAnswerFragmentUser newInstance(String param1, String param2) {
        LongAnswerFragmentUser fragment = new LongAnswerFragmentUser();
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
        View v = inflater.inflate(R.layout.fragment_long_answer_user, container, false);

        typicalDay = v.findViewById(R.id.typicalDay);
        worstHabit = v.findViewById(R.id.worstHabit);
        hopeRoommate = v.findViewById(R.id.hopeRoommate);
        other = v.findViewById(R.id.other);

        Context context = getActivity();

        SharedPreferences myPrefs = PreferenceManager.getDefaultSharedPreferences(context);

        typicalDay.setText(myPrefs.getString("longAnswer1", ""));
        worstHabit.setText(myPrefs.getString("longAnswer2", ""));
        hopeRoommate.setText(myPrefs.getString("longAnswer3", ""));
        other.setText(myPrefs.getString("longAnswer4", ""));

        return v;
    }
}
