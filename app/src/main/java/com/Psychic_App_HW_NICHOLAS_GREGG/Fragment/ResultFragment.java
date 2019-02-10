package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Psychic_App_HW_NICHOLAS_GREGG.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {


    public static ResultFragment newInstance(String result) {
        return new ResultFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_result, container, false);
    }

}
