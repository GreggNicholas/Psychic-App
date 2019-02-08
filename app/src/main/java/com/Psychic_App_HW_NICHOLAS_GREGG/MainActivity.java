package com.Psychic_App_HW_NICHOLAS_GREGG;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Psychic_App_HW_NICHOLAS_GREGG.Fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runMainFragment();


    }


    private void runMainFragment() {
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, mainFragment)
                .commit();
    }
}
