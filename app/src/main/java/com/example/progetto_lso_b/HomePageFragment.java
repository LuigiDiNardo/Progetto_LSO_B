package com.example.progetto_lso_b;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomePageFragment extends AppCompatActivity {
    private EditText nomeEditText;
    private EditText cognomeEditText;
    private EditText natoEditText;
    private EditText usernameEditText;

  //  public static final String SHARED_PREFS = "sharedPrefs";
   // public static final String USER = "user";

    private String text;




    public HomePageFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_home_page);
        getSupportActionBar().hide();

        Button procediButton = findViewById(R.id.procedi_button);
        nomeEditText = (EditText) findViewById(R.id.nome_editText);
        cognomeEditText = (EditText) findViewById(R.id.cognome_editText);
        natoEditText = (EditText) findViewById(R.id.nato_editText);
        usernameEditText = (EditText) findViewById(R.id.username_editText);


        procediButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveData();
                Intent intent = new Intent(HomePageFragment.this, MainActivity.class);
                startActivity(intent);

            }
        });

        loadData();
        updateViews();
    }



    @Override
    public void onStop() {
        getSupportActionBar().show();

        super.onStop();
    }

    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("user", usernameEditText.getText().toString());

        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        text = sharedPreferences.getString("user","");

    }

    public void updateViews(){
        usernameEditText.setText(text);
    }

}