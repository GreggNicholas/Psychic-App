package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Psychic_App_HW_NICHOLAS_GREGG.Database.ChoicedatabaseHelper;
import com.Psychic_App_HW_NICHOLAS_GREGG.Listener.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.Model.Choice;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private View v;
    private TextView resultTextView;
    private ChoicedatabaseHelper dbHelper;
    FragmentInterface fragmentInterface;

    public static ResultFragment newInstance() {
        return new ResultFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_result, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultTextView = v.findViewById(R.id.result_textview);
        dbHelper = new ChoicedatabaseHelper(view.getContext());
        Choice choice = dbHelper.correctChoice();
        resultTextView.setText(getString(R.string.correct, choice.getCorrectChoices()));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fragmentInterface != null) fragmentInterface = null;

    }
}
