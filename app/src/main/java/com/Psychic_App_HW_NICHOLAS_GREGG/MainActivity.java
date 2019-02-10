package com.Psychic_App_HW_NICHOLAS_GREGG;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.MainFragment;
import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.ResultFragment;

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
    public void choiceFragLauncher(String choice) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container_main, newInstance("choice"))
                .addToBackStack("main")
                .commit();
    }

    @Override
    public void resultFragLauncher(String result) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container_main, ResultFragment.newInstance(result))
                .addToBackStack("choice")
                .commit();
    }
}
