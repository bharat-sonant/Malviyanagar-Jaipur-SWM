package com.vCare.malviyanagarjaipurmsw;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vCare.malviyanagarjaipurmsw.Fragments.CardData;
import com.vCare.malviyanagarjaipurmsw.Fragments.ComplainPage;
import com.vCare.malviyanagarjaipurmsw.Fragments.HomePage;
import com.vCare.malviyanagarjaipurmsw.Fragments.ProfilePage;

public class MainScreen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigation;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    private long mLastClickTime = 0;
    SharedPreferences preferences;
    String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        bottomNavigation = findViewById(R.id.bottomNavigation);
        preferences = getSharedPreferences("CITIZEN APP", MODE_PRIVATE);
        bottomNavigation.setOnNavigationItemSelectedListener(this);
        bottomNavigation.setSelectedItemId(R.id.homeBtn);

    }


    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    ComplainPage complainPage = new ComplainPage();
    CardData cardData = new CardData();

        @Override
        public boolean onNavigationItemSelected (@NonNull MenuItem item){

            switch (item.getItemId()) {

                case R.id.homeBtn:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contains, homePage).commit();
                    return true;

                case R.id.profileBtn:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contains, profilePage).commit();
                    return true;

                case R.id.complaintsBtn:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contains, complainPage).commit();
                    return true;

                case R.id.scanCardData:
                    getSupportFragmentManager().beginTransaction().replace(R.id.contains, cardData).commit();
                    return true;
            }
            return false;
        }

    }