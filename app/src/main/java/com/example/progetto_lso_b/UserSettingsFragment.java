package com.example.progetto_lso_b;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;


public class UserSettingsFragment extends Fragment {

    private TextView usernameText;
    private TextView Bio;
    private TextView cambiaBio;
    private TextView dataDiNascita;
    private TextView username;
    private TextView cambiaDataDiNascita;
    private TextView cambioUsername;
    private CircleImageView immagineProfilo;
    private TextView cambiaFoto;



    public UserSettingsFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {


        //Recupero l'action bar relativa alla activity
        ActionBar actionBar1 = ((AppCompatActivity) getActivity()).getSupportActionBar();
        //Mostra il backbutton
        actionBar1.setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.menu);
        bottomNavigationView.setVisibility(View.GONE);


        super.onCreate(savedInstanceState);

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_settings, container, false);

        usernameText = view.findViewById(R.id.UserSettings_textView);
        usernameText.setText(SharedPref.getString("user", null));

        Bio = view.findViewById(R.id.bioSettings_textView);
        Bio.setText(SharedPref.getString("bio", null));

        dataDiNascita = view.findViewById(R.id.dataDiNascita_textView);
        dataDiNascita.setText(SharedPref.getString("nascita", null));

        username = view.findViewById(R.id.Nickname_textView);
        username.setText(SharedPref.getString("user", null));

        immagineProfilo = view.findViewById(R.id.avatar_UserSettings_imageView);
        cambiaFoto = view.findViewById(R.id.cambiaFoto_textView);







        cambiaFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        cambioUsername = view.findViewById(R.id.boxCambioNickname_textView);
        cambioUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final EditText edittext = new EditText(getActivity());
                alert.setMessage("Inserisci un nuovo nickname...");
                alert.setTitle("Nickname");

                alert.setView(edittext);

                alert.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Editable testo = edittext.getText();
                        SharedPref.putString("user", testo.toString());

                        username.setText(SharedPref.getString("user", null));


                    }
                });


                alert.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                alert.show();
            }


        });


        cambiaDataDiNascita = view.findViewById(R.id.boxCambioDataNascita_textView);
        cambiaDataDiNascita.setOnClickListener(new View.OnClickListener() {


            final Calendar calendar = Calendar.getInstance();
            int anno = calendar.get(Calendar.YEAR);
            int mese = calendar.get(Calendar.MONTH);
            int giorno = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        int mont = month + 1;
                        if (year < 1921 || year > 2006) {
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                            builder1.setMessage("Inserire una data di nascita valida");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "Ok",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                            builder1.show();

                        } else {
                            SharedPref.putString("nascita", day + "/" + mont + "/" + year);
                            dataDiNascita.setText(SharedPref.getString("nascita", null));

                        }
                    }
                }, anno, mese + 1, giorno);
                datePickerDialog.show();

            }


        });


        cambiaBio = view.findViewById(R.id.boxCambioBio_textView);
        cambiaBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                final EditText edittext = new EditText(getActivity());
                alert.setMessage("Inserisci la tua bio...");
                alert.setTitle("Biografia");

                alert.setView(edittext);

                alert.setPositiveButton("Conferma", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        Editable testo = edittext.getText();
                        SharedPref.putString("bio", testo.toString());

                        Bio.setText(SharedPref.getString("bio", null));


                    }
                });


                alert.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                });

                alert.show();
            }

        });


        return view;
    }



    }





