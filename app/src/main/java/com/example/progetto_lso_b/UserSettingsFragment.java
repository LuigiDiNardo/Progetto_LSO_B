package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


public class UserSettingsFragment extends Fragment {

    public UserSettingsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Recupero l'action bar relativa alla activity
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();

        //Mostra il backbutton
        actionBar1.setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);

    }


    @Override
    public void onPause() {
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();

        //disattiva il back button quando il fragment viene chiuso
        actionBar1.setDisplayHomeAsUpEnabled(false);

        super.onPause();
    }

    @Override
    public void onResume() {
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();

        //disattiva il back button quando il fragment viene chiuso
        actionBar1.setDisplayHomeAsUpEnabled(true);
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_settings, container, false);





    }
}