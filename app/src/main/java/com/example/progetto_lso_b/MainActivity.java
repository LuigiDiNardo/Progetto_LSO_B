package com.example.progetto_lso_b;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.provider.Contacts;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView buttonNV= findViewById(R.id.menu);
        buttonNV.setOnNavigationItemSelectedListener(navListener);


        getSupportFragmentManager().beginTransaction().replace(R.id.online_frame,new OnlineStatusFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.people_frame,new PeopleFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.messages_frame,new MessagesFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedItem = null;
                    switch(item.getItemId()){

                        case R.id.Home:
                            break;
                        case R.id.Message:
                            break;
                        case R.id.Search:
                            break;
                        case R.id.Setting:
                            break;
                        default:
                            break;
                    }

                    return true;
                }
            };



}