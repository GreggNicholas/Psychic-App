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

import com.Psychic_App_HW_NICHOLAS_GREGG.FragmentInterface;
import com.Psychic_App_HW_NICHOLAS_GREGG.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoiceFragment extends Fragment {
    private View v;
    private String westWorldData;
    private String gameOfThronesData;
    private String mortalKombatData;
    private ImageView imageViewChoice1;
    private ImageView imageViewChoice2;
    private ImageView imageViewChoice3;
    private ImageView imageViewChoice4;
    private FragmentInterface fragmentInterface;
    private static final String BUNDLE_KEY = "input";


    public static ChoiceFragment newInstance(String choice) {
        ChoiceFragment fragment = new ChoiceFragment();
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, choice);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        fragmentInterface = (FragmentInterface) context;
        super.onAttach(context);
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

        String chosenTheme = getArguments().getString(BUNDLE_KEY);

        imageViewChoice1 = v.findViewById(R.id.imageview1_choicefragment);
        imageViewChoice2 = v.findViewById(R.id.imageview2_choicefragment);
        imageViewChoice3 = v.findViewById(R.id.imageview3_choicefragment);
        imageViewChoice4 = v.findViewById(R.id.imageview4_choicefragment);

        if (getArguments() != null) {
            switch (chosenTheme) {
                case "Westworld":
                    imageViewChoice1.setImageResource(R.drawable.wwimagesdoloreww);
                    imageViewChoice2.setImageResource(R.drawable.wwimagesww);
                    imageViewChoice3.setImageResource(R.drawable.wwimageww);
                    imageViewChoice4.setImageResource(R.drawable.wwmazeww);
                    break;
                case "Game of Thrones":
                    imageViewChoice1.setImageResource(R.drawable.gotdaenarysgot);
                    imageViewChoice2.setImageResource(R.drawable.gotjondagodsnowgot);
                    imageViewChoice3.setImageResource(R.drawable.gotnightkinggot);
                    imageViewChoice4.setImageResource(R.drawable.gotmountainandvipergot);
                    break;
                case "Mortal Kombat":
                    imageViewChoice1.setImageResource(R.drawable.mkraidenmk);
                    imageViewChoice2.setImageResource(R.drawable.mkkitanamk);
                    imageViewChoice3.setImageResource(R.drawable.mknoobsaibotmk);
                    imageViewChoice4.setImageResource(R.drawable.mksubzeromk);
                    break;
            }
        }
    }

    public void themeSelector() {


    }


}
