package com.example.progetto_lso_b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.Manifest;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    static boolean first_log=true; //variabile per indicare se la home è caricata la prima volta o meno
    NavController navController;
    private static final String[] permessi = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    private final static int requestcode = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,permessi,requestcode);
        }
        if (first_log){ //se è la prima volta che si va nella home si carica automaticamente il fragment; altrimenti lo gestisce il navController (guarda sotto)
            getSupportFragmentManager().beginTransaction().replace(R.id.hello_frame, new HelloUser_fragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.online_frame, new OnlineStatusFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.people_frame, new PeopleFragment()).commit();
            getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame, new MessagesFragment()).commit();
            first_log=false;
        }

        NavHostFragment navHostFragment= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);//Componente che ci permette di spostarci tra i vari fragment.
        navController=navHostFragment.getNavController();
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportActionBar().setTitle("Homepage");

    }



    //Listener del menu
    private  BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch(item.getItemId()){//cliccando un icona del menu ne otterremo l'id
                        case R.id.Home:
                            navController.navigate(R.id.homeFragment);
                            getSupportFragmentManager().beginTransaction().replace(R.id.hello_frame, new HelloUser_fragment()).commit();
                            getSupportFragmentManager().beginTransaction().replace(R.id.online_frame, new OnlineStatusFragment()).commit();
                            getSupportFragmentManager().beginTransaction().replace(R.id.people_frame, new PeopleFragment()).commit();
                            getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame, new MessagesFragment()).commit();


                            break;
                        case R.id.Message:
                            navController.navigate(R.id.chatFragment);
                            getSupportActionBar().setTitle("Inbox");

                            break;
                        case R.id.Search:
                            navController.navigate(R.id.searchFragment);
                            getSupportActionBar().setTitle("Search");
                            break;
                        case R.id.Setting:
                            navController.navigate(R.id.settingsFragment);
                            getSupportActionBar().setTitle("Impostazioni");
                            break;
                        default: break;

                    }
                    return true;
                }
            };


    public static String[] getPermessi() {
        return permessi;
    }
    public static int getRequestcode() {
        return requestcode;
    }

    //@Override
   // public boolean onOptionsItemSelected(@NonNull MenuItem item) {
      /*  switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }*/
      //  Intent myIntent = new Intent((getApplicationContext()), MainActivity.class);
      //  startActivityForResult(myIntent,0);
        //return super.onOptionsItemSelected(item);

       // return super.onOptionsItemSelected(item);

  //  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
      if(getFragmentManager().getBackStackEntryCount() == 1) {
          moveTaskToBack(false);
      }
      else {
          super.onBackPressed();
      }
      return true;
  }


}