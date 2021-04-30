package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomePageFragment extends Fragment {



    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        BottomNavigationView navBar = getActivity().findViewById(R.id.menu);
        navBar.setVisibility(View.GONE);


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false);
    }

    @Override
    public void onStop() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();
        BottomNavigationView navBar = getActivity().findViewById(R.id.menu);
        navBar.setVisibility(View.VISIBLE);


        super.onStop();
    }
}