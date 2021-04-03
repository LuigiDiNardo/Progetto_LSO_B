package com.example.progetto_lso_b;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class SettingsFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       final View view = inflater.inflate(R.layout.fragment_settings, container, false);

       Button userSettingsButton = view.findViewById(R.id.userSettings_button);
       userSettingsButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_userSettingsFragment);
           }
       });

       Button privacyButton = view.findViewById(R.id.privacy_button);
        privacyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_privacyFragment);
            }
        });

        Button impostNotificheButton = view.findViewById(R.id.impostNotifiche_button);
        impostNotificheButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_impostNotificheFragment);
            }
        });

        Button appStyleButton = view.findViewById(R.id.appStyle_button);
        appStyleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_appStyleFragment);
            }
        });

        Button logOutButton = view.findViewById(R.id.logOut_button);
        logOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_logOutFragment);
            }
        });







    return view;
    }
}