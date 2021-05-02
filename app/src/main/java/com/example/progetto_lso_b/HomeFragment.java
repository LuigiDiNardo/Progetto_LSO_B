package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class HomeFragment extends Fragment {

    public HomeFragment() {

    }

    public void onCreate(Bundle savedInstance){
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Homepage");

       // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}