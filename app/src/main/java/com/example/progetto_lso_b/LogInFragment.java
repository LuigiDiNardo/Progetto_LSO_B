package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LogInFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {

        //Recupera l'action bar relativa all'activity e la nasconde
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onStop() {

        //recupera l'action bar relativa all'activity e la mostra di nuovo una volta che il fragment viene
        //chiuso
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        super.onStop();
    }
}