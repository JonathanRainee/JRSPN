package com.example.blujekpharmacy.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.blujekpharmacy.MapsFragment;
import com.example.blujekpharmacy.R;

public class About extends AppCompatActivity {

    MapsFragment mapsFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        mapsFragment = new MapsFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.mapFragment, mapsFragment).commit();
    }
}