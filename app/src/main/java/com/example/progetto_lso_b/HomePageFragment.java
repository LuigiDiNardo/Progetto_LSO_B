package com.example.progetto_lso_b;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.regex.Pattern;


public class HomePageFragment extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText cognomeEditText;
    private Button natoButton;
    private EditText usernameEditText;
    private boolean checkNome, checkCognome, checkUsername, checkNascita;
    //public static final String SHARED_PREFS = "sharedPrefs";
    //public static final String USER = "user";



    private String nome, cognome, username, nascita;

    public HomePageFragment() {

    }

    public void saveData(String username, String nome, String cognome, String nascita, boolean signUp) {
        SharedPref.putString("user",username);
        SharedPref.putString("nome",nome);
        SharedPref.putString("cognome",cognome);
        SharedPref.putString("nascita",nascita);
        SharedPref.putBoolean("signUp",true);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPref.init(getApplicationContext());

        if (SharedPref.isSignedUp("signUp")) {
            Intent intent = new Intent(HomePageFragment.this, MainActivity.class);
            startActivity(intent);
        } else {

            setContentView(R.layout.fragment_home_page);
            getSupportActionBar().hide();

            Button procediButton = findViewById(R.id.procedi_button);
            nomeEditText = findViewById(R.id.nome_editText);
            cognomeEditText = findViewById(R.id.cognome_editText);
            natoButton = findViewById(R.id.nascitabutton);
            usernameEditText = findViewById(R.id.username_editText);

            nomeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View view, boolean b) {
                    String nome = nomeEditText.getText().toString();
                    TextView tv = findViewById(R.id.warningNome_textView);
                    if (nome.length() == 0) {
                        tv.setText("Non può essere vuoto!");
                        tv.setVisibility(View.VISIBLE);
                        checkNome = false;
                    } else {
                        Pattern pattern = Pattern.compile("[a-zA-Z]+");
                        if (!pattern.matcher(nome).find()) {
                            tv.setText("Non sono ammessi caratteri speciali\nal di fuori delle lettere 'accentate'");
                            tv.setVisibility(View.VISIBLE);
                            checkNome = false;
                        } else {
                            tv.setVisibility(View.INVISIBLE);
                            checkNome = true;
                        }
                    }
                }
            });

            cognomeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View view, boolean b) {
                    String cognome = cognomeEditText.getText().toString();
                    TextView tv = findViewById(R.id.warningCognome_textView);
                    if (cognome.length() == 0) {
                        tv.setText("Non può essere vuoto!");
                        tv.setVisibility(View.VISIBLE);
                        checkCognome = false;
                    } else {
                        Pattern pattern = Pattern.compile("[a-zA-Z]+[a-zA-Z]+");
                        if (!pattern.matcher(cognome).find()) {
                            tv.setText("Non sono ammessi caratteri speciali\nal di fuori delle lettere 'accentate'");
                            tv.setVisibility(View.VISIBLE);
                            checkCognome = false;
                        } else {
                            tv.setVisibility(View.INVISIBLE);
                            checkCognome = true;
                        }
                    }
                }
            });

            usernameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {

                @Override
                public void onFocusChange(View view, boolean b) {
                    String username = usernameEditText.getText().toString();
                    TextView tv = findViewById(R.id.warningUsername_textView);
                    String text = tv.getText().toString();
                    if (username.length() == 0) {
                        tv.setText("Non può essere vuoto!");
                        tv.setVisibility(View.VISIBLE);
                        tv.setText(text);
                        checkUsername = false;
                    } else {
                        Pattern pattern = Pattern.compile("\\w+");
                        if (!pattern.matcher(username).find()) {
                            tv.setVisibility(View.VISIBLE);
                            checkUsername = false;
                        } else {
                            tv.setVisibility(View.INVISIBLE);
                            checkUsername = true;
                        }
                    }
                }
            });

            natoButton.setOnClickListener(new View.OnClickListener() {

                final Calendar calendar= Calendar.getInstance();
                int anno = calendar.get(Calendar.YEAR);
                int mese = calendar.get(Calendar.MONTH);
                int giorno = calendar.get(Calendar.DAY_OF_MONTH);

                TextView tv = findViewById(R.id.warningDate_textView);
                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(HomePageFragment.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                            int mont=month+1;
                            natoButton.setText(day + "/" + mont + "/" + year);
                            if(year<1921 || year>2006){
                                tv.setText("Devi avere tra i 99 ed i 16 anni\nper usare l'app");
                                tv.setVisibility(View.VISIBLE);
                                checkNascita=false;
                            }
                            else{
                                tv.setVisibility(View.INVISIBLE);
                                checkNascita=true;
                            }
                        }
                    }, anno, mese+1, giorno);
                    datePickerDialog.show();

                }
            });




            procediButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    if (checkCognome && checkNascita && checkNome && checkUsername) {
                        username = usernameEditText.getText().toString();
                        nome = nomeEditText.getText().toString();
                        nascita = natoButton.getText().toString();
                        cognome = cognomeEditText.getText().toString();

                        saveData(username, nome, cognome, nascita, true);
                        Intent intent = new Intent(HomePageFragment.this, MainActivity.class);
                        startActivity(intent);

                    }
                }
            });
        }

    }
}

