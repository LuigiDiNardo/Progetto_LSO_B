package com.example.progetto_lso_b;


import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SettingsFragment extends Fragment {

    private TextView tv;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar1.setDisplayHomeAsUpEnabled(false);
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.menu);
        bottomNavigationView.setVisibility(View.VISIBLE);
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       final View view = inflater.inflate(R.layout.fragment_settings, container, false);

       tv= view.findViewById(R.id.nomeUtente_textView);
       tv.setText(SharedPref.getString("user",null));

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
                //Navigation.findNavController(view).navigate(R.id.action_settingsFragment_to_homePageFragment);

            }
        });

        Button logOutButton = view.findViewById(R.id.logOut_button);
        logOutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
                alertDialog.setTitle("Log Out");
                alertDialog.setMessage("Vuoi davvero effettuare il LogOut?");
                alertDialog.setPositiveButton("Sì",null)
                           .setNegativeButton("No",null);
               /* alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                              //  dialog.dismiss();
                            }

                            });
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // dialog.dismiss();
                    }
                });*/

                alertDialog.show();


            }






        });




    return view;
    }}


