package com.Psychic_App_HW_NICHOLAS_GREGG.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.Psychic_App_HW_NICHOLAS_GREGG.Listener.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {
    private View v;
    private static FragmentInterface fragmentInterface;
    private static List<Integer> drawables;
    private static List<ImageView> images = new ArrayList<>();

    public static ChoiceFragment newInstance(List<Integer> images) {
        ChoiceFragment fragment = new ChoiceFragment();
        drawables = images;
        return fragment;
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

        v = inflater.inflate(R.layout.fragment_choice, container, false);
        return v;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageView imageViewChoice1 = v.findViewById(R.id.imageview1_choicefragment);
        final ImageView imageViewChoice2 = v.findViewById(R.id.imageview2_choicefragment);
        final ImageView imageViewChoice3 = v.findViewById(R.id.imageview3_choicefragment);
        final ImageView imageViewChoice4 = v.findViewById(R.id.imageview4_choicefragment);

        imageViewChoice1.setImageDrawable(getResources().getDrawable(drawables.get(0)));
        imageViewChoice2.setImageDrawable(getResources().getDrawable(drawables.get(1)));
        imageViewChoice3.setImageDrawable(getResources().getDrawable(drawables.get(2)));
        imageViewChoice4.setImageDrawable(getResources().getDrawable(drawables.get(3)));

        images.add(imageViewChoice1);
        images.add(imageViewChoice2);
        images.add(imageViewChoice3);
        images.add(imageViewChoice4);


        imageViewChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.resultFragLauncher();
            }
        });
        imageViewChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.resultFragLauncher();
            }
        });
        imageViewChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.resultFragLauncher();
            }
        });
        imageViewChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentInterface.resultFragLauncher();
            }
        });


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fragmentInterface != null) fragmentInterface = null;
    }
}
