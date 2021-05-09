package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ImpostNotificheFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Recupero l'action bar relativa alla activity
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();
        //Mostra il backbutton
        actionBar1.setDisplayHomeAsUpEnabled(true);
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.menu);
        bottomNavigationView.setVisibility(View.GONE);

        super.onCreate(savedInstanceState);

    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_impost_notifiche, container, false);
    }
}