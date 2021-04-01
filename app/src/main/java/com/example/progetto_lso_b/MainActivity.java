package com.example.progetto_lso_b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.NavHost;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    static boolean first_log=true; //variabile per indicare se la home è caricata la prima volta o meno
    NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (first_log){ //se è la prima volta che si va nella home si carica automaticamente il fragment; altrimenti lo gestisce il navController (guarda sotto)
            getSupportFragmentManager().beginTransaction().replace(R.id.online_frame, new OnlineStatusFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.people_frame, new PeopleFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame, new MessagesFragment()).commit();
            first_log=false;
        }

        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);//Componente che ci permette di spostarci tra i vari fragment.
        navController=navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

    }

    //Listener del menu
    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId()){//cliccando un icona del menu ne otterremo l'id
                        case R.id.Home:
                            navController.navigate(R.id.homeFragment);
                            getSupportFragmentManager().beginTransaction().replace(R.id.online_frame, new OnlineStatusFragment()).commit();
                            getSupportFragmentManager().beginTransaction().replace(R.id.people_frame, new PeopleFragment()).commit();
                            getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame, new MessagesFragment()).commit();
                            break;
                        case R.id.Message:
                            navController.navigate(R.id.chatFragment);
                            break;
                        case R.id.Search:
                            navController.navigate(R.id.searchFragment);
                            break;
                        case R.id.Setting:
                            navController.navigate(R.id.settingsFragment);
                            break;
                        default: break;

                    }
                    return true;
                }
            };

}