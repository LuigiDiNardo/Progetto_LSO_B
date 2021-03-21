package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OnlineStatusFragment extends Fragment {

    public OnlineStatusFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate il layout per questo fragment
        return inflater.inflate(R.layout.online_fragment, container, false);
    }
}