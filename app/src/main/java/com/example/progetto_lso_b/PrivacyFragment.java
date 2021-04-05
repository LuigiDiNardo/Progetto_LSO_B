package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrivacyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrivacyFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();

        actionBar1.setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);

    }


    @Override
    public void onStop() {

        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();


        actionBar1.setDisplayHomeAsUpEnabled(false);


        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_privacy, container, false);
    }
}