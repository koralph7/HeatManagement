package com.battman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;

public class BatteryActivity extends AppCompatActivity implements BatteryFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battery);

        FrameLayout container = findViewById(R.id.batteryContainer);
        if(container != null){
            Fragment fragment = BatteryFragment.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.batteryContainer, fragment);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onItemSelected(Battery battery) {
        Toast.makeText(this, "Battery selected: " + battery,
                Toast.LENGTH_LONG).show();
    }
}