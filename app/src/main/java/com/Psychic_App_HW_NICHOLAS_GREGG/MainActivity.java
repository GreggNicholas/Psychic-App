package com.Psychic_App_HW_NICHOLAS_GREGG;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.ChoiceFragment;
import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.MainFragment;
import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.ResultFragment;

import java.util.List;

import static com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.ChoiceFragment.newInstance;
import static com.Psychic_App_HW_NICHOLAS_GREGG.R.id.container_main;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragmentLauncher();


    }


    private void mainFragmentLauncher() {
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container_main, mainFragment)
                .commit();
    }

    @Override
    public void choiceFragLauncher(List<Integer> drawables) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container_main, ChoiceFragment.newInstance(drawables))
                .addToBackStack("main")
                .commit();
    }

    @Override
    public void resultFragLauncher() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container_main, ResultFragment.newInstance())
                .addToBackStack("choice")
                .commit();
    }
}
