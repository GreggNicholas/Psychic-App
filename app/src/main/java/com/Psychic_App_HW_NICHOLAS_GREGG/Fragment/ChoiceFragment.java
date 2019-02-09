package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Psychic_App_HW_NICHOLAS_GREGG.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {
private String jimCareyData;
private String gameOfThronesData;
private String mortalKombatData;
private ImageView choiceImageView1;
private ImageView choiceImageView2;
private ImageView choiceImageView3;
private ImageView choiceImageView4;

private View v;
private FragmentInterface fragmentInterface;



//    public ChoiceFragment() {
//        // Required empty public constructor
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_choice, container, false);

        return v;
    }

}
