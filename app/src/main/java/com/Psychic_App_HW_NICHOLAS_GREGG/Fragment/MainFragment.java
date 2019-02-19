package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


import com.Psychic_App_HW_NICHOLAS_GREGG.Listener.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private Spinner dropDown;
    private static FragmentInterface fragmentInterface;
    private int selectedchoice;
    private View v;
    private Button button;
    List<Integer> drawables;


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_main, container, false);
        button = v.findViewById(R.id.button_fragment);
        dropDown = v.findViewById(R.id.spinner_main);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dropDownMenu();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (selectedchoice) {
                    case 1:
                        drawables = Arrays.asList(R.drawable.imagesdoloreww, R.drawable.imagesww, R.drawable.imagewwjpeg, R.drawable.mazeww);
                        fragmentInterface.choiceFragLauncher(drawables);
                        break;
                    case 2:
                        drawables = Arrays.asList(R.drawable.gotdaenarysgot, R.drawable.gotjondagodsnowgot, R.drawable.gotmountainandvipergot, R.drawable.gotnightkinggot);
                        fragmentInterface.choiceFragLauncher(drawables);
                        break;
                    case 3:
                        drawables = Arrays.asList(R.drawable.mkkitanamk, R.drawable.mknoobsaibotmk, R.drawable.mkraidenmk, R.drawable.mksubzeromk);
                        fragmentInterface.choiceFragLauncher(drawables);
                        break;
                }
            }
        });
    }

    private void dropDownMenu() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(), R.array.choices, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropDown.setAdapter(adapter);
        dropDown.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String confirm = "Please confirm ";
        String toasty = parent.getItemAtPosition(position).toString() + " theme";
        selectedchoice = position;

        if (parent.getItemAtPosition(position).toString().equals("Select a theme")) {
            Toast.makeText(parent.getContext(), "Please select a theme", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(parent.getContext(), confirm + toasty, Toast.LENGTH_SHORT).show();

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fragmentInterface != null) fragmentInterface = null;
    }
}



