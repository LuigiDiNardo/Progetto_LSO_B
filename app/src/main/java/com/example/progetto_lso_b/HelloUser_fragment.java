package com.example.progetto_lso_b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class HelloUser_fragment extends Fragment {


    private TextView usernameText;
    private String username;

    public HelloUser_fragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // TextView usernameText = getActivity().findViewById(R.id.username_textView);
        View view = inflater.inflate(R.layout.fragment_hello_user_fragment, container, false);
        usernameText = view.findViewById(R.id.usernameFrag_textView);


       // SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

         SharedPreferences sp = getActivity().getSharedPreferences("myKey", getContext().MODE_PRIVATE);
        username = sp.getString("user",null);
        usernameText.setText(username);



        return view;
    }
}