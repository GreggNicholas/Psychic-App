package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.Psychic_App_HW_NICHOLAS_GREGG.R;

import java.io.ObjectInput;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner dropDown;


//    public static MainFragment newInstance() {
//        // Required empty public constructor
//        return
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        dropDown = v.findViewById(R.id.spinner_main);
        Button button = v.findViewById(R.id.button_fragment);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        dropDownMenu();
        return v;
    }

    private void dropDownMenu() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String confirm = "Please confirm ";
        String toasty = parent.getItemAtPosition(position).toString() + " theme";

        if (parent.getItemAtPosition(position).toString().equals("\n")) {
            Toast.makeText(parent.getContext(), "Please select a theme", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(parent.getContext(), confirm + toasty, Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
