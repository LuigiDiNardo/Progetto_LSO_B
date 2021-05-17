package com.example.progetto_lso_b;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import android.text.Editable;
import android.view.ContextThemeWrapper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class SettingsFragment extends Fragment {

    private TextView tv;
    private TextView Bio;
    private TextView testoBio;


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

               // getContext().getTheme().applyStyle(R.style.DarkTheme, true);

            }
        });



        Bio = view.findViewById(R.id.cambiaBio2_textView);
       
        Bio.setText(SharedPref.getString("bio",null));
        testoBio = view.findViewById(R.id.cambiaBio2_textView);
        testoBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final EditText edittext = new EditText(getActivity());
                alert.setMessage("Inserisci la tua bio...");
                alert.setTitle("Biografia");

                alert.setView(edittext);

                alert.setPositiveButton("Yes Option", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Editable testo = edittext.getText();
                        SharedPref.putString("bio", testo.toString());
                        Bio.setText(SharedPref.getString("bio", null));
                    }
                });

                alert.setNegativeButton("No Option", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                alert.show();
            }
        });

    return view;
    }
 }



