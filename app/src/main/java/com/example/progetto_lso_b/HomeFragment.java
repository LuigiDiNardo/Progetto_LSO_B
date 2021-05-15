package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
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

        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();
        //disattiva il back button quando il fragment viene chiuso
        actionBar1.setDisplayHomeAsUpEnabled(false);

       // ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        super.onCreate(savedInstance);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.hello_frame, new HelloUser_fragment()).commit();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.online_frame, new OnlineStatusFragment()).commit();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.people_frame, new PeopleFragment()).commit();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame, new MessagesFragment()).commit();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


}