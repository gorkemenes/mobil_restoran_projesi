package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bottomnavi;

    String kullanici;
    String masa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        bottomnavi = findViewById(R.id.bottomnavi);

        //Menu Fragment
        kullanici = getIntent().getStringExtra("kullanici");
        masa = getIntent().getStringExtra("masa");


        getSupportFragmentManager().beginTransaction().replace(R.id.frag,new MenuFragment()).commit();
        bottomnavi.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag,new MenuFragment()).commit();
                        break;
                    case R.id.siparis:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag,new SiparisFragment()).commit();
                        break;
                    case R.id.profil:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frag,new ProfilFragment()).commit();
                        break;
                }
                return true;
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}