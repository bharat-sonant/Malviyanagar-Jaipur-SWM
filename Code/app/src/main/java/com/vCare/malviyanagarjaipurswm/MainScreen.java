package com.vCare.malviyanagarjaipurswm;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vCare.malviyanagarjaipurswm.Fragments.CardData;
import com.vCare.malviyanagarjaipurswm.Fragments.ComplainPage;
import com.vCare.malviyanagarjaipurswm.Fragments.HomePage;
import com.vCare.malviyanagarjaipurswm.Fragments.ProfilePage;

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
        flag = preferences.getString("sawachh","");

        if (!flag.equals("true"))
            showAlertBox("सवच्छता सर्वेक्षण में भाग लेने के लिए OK बटन पर क्लिक करे", "OK", "CANCEL", MainScreen.this);

    }

    HomePage homePage = new HomePage();
    ProfilePage profilePage = new ProfilePage();
    ComplainPage complainPage = new ComplainPage();
    CardData cardData = new CardData();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

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

    public void showAlertBox(String message, String pBtn, String nBtn, Context ctx) {
        hideAlertBox();
        builder = new AlertDialog.Builder(ctx);
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton(nBtn, (dialog, i) -> dialog.cancel())
                .setPositiveButton(pBtn, (dialogInterface, i) -> {
                    Intent intent = new Intent(MainScreen.this,FeedbackActivity.class);
                    startActivity(intent);
                });
        alertDialog = builder.create();
        alertDialog.show();
    }

    public void hideAlertBox() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void showAlertDialog() {

        View dialogLayout = MainScreen.this.getLayoutInflater().inflate(R.layout.custom_swachhata_alertbox, null);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainScreen.this).setView(dialogLayout).setCancelable(false);
        AlertDialog dialog = alertDialog.create();
        TextView tv_redirect_link = dialogLayout.findViewById(R.id.tv_link);
        tv_redirect_link.setText("https://sbmurban.org/feedback");
        tv_redirect_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preferences.edit().putString("sawachh","true").apply();
            }
        });
        ImageView closeBtn = dialogLayout.findViewById(R.id.btnClose);
        closeBtn.setOnClickListener(v -> {
            if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                return;
            }
            mLastClickTime = SystemClock.elapsedRealtime();
            dialog.cancel();

        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();


    }
}