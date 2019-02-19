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

import com.Psychic_App_HW_NICHOLAS_GREGG.Database.ChoicedatabaseHelper;
import com.Psychic_App_HW_NICHOLAS_GREGG.Listener.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {
    private View v;
    private static FragmentInterface fragmentInterface;
    private static List<Integer> drawables;
    private int selectedChoice;
    private static List<ImageView> images = new ArrayList<>();
    ImageView imageViewChoice1;
    ImageView imageViewChoice2;
    ImageView imageViewChoice3;
    ImageView imageViewChoice4;

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

        imageViewChoice1 = v.findViewById(R.id.imageview1_choicefragment);
        imageViewChoice2 = v.findViewById(R.id.imageview2_choicefragment);
        imageViewChoice3 = v.findViewById(R.id.imageview3_choicefragment);
        imageViewChoice4 = v.findViewById(R.id.imageview4_choicefragment);

        imageViewChoice1.setImageDrawable(getResources().getDrawable(drawables.get(0)));
        imageViewChoice2.setImageDrawable(getResources().getDrawable(drawables.get(1)));
        imageViewChoice3.setImageDrawable(getResources().getDrawable(drawables.get(2)));
        imageViewChoice4.setImageDrawable(getResources().getDrawable(drawables.get(3)));

        images.add(imageViewChoice1);
        images.add(imageViewChoice2);
        images.add(imageViewChoice3);
        images.add(imageViewChoice4);

        imageViewClickListener1();
        imageViewClickListener2();
        imageViewClickListener3();
        imageViewClickListener4();
    }


    private void imageViewClickListener1() {
        Random random = new Random();
        final int randomGenerator = random.nextInt(4) + 1;
        imageViewChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomGenerator == 1) {
                    addRandomToDataBase(1);
                    fragmentInterface.resultFragLauncher();
                } else {
                    addRandomToDataBase(0);
                    fragmentInterface.resultFragLauncher();
                }
            }

        });
    }

    private void imageViewClickListener2() {
        Random random = new Random();
        final int randomGenerator = random.nextInt(4) + 1;
        imageViewChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomGenerator == 1) {
                    addRandomToDataBase(1);
                    fragmentInterface.resultFragLauncher();
                } else {
                    addRandomToDataBase(0);
                    fragmentInterface.resultFragLauncher();
                }
            }

        });
    }

    private void imageViewClickListener3() {
        Random random = new Random();
        final int randomGenerator = random.nextInt(4) + 1;
        imageViewChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomGenerator == 1) {
                    addRandomToDataBase(1);
                    fragmentInterface.resultFragLauncher();
                } else {
                    addRandomToDataBase(0);
                    fragmentInterface.resultFragLauncher();
                }
            }

        });
    }

    private void imageViewClickListener4() {
        Random random = new Random();
        final int randomGenerator = random.nextInt(4) + 1;
        imageViewChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (randomGenerator == 1) {
                    addRandomToDataBase(1);
                    fragmentInterface.resultFragLauncher();
                } else {
                    addRandomToDataBase(0);
                    fragmentInterface.resultFragLauncher();
                }
            }

        });
    }

    private void addRandomToDataBase(int choice) {
        ChoicedatabaseHelper dbHelper = ChoicedatabaseHelper.getInstance(getContext());
        dbHelper.addChoice(choice);
        fragmentInterface.resultFragLauncher();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (fragmentInterface != null) fragmentInterface = null;
    }
}
