package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Masa extends AppCompatActivity {


    ImageButton imagebir,imageiki,imageuc,imagedort,imagebes,imagealti;


    DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        String kullanici = getIntent().getStringExtra("mesaj");



        imagebir = findViewById(R.id.imagebir);
        imageiki = findViewById(R.id.imageiki);
        imageuc = findViewById(R.id.imageuc);
        imagedort = findViewById(R.id.imagedort);
        imagebes = findViewById(R.id.imagebes);
        imagealti = findViewById(R.id.imagealti);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");

        myRef.child("Aktif Siparişler").addListenerForSingleValueEvent(new ValueEventListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.hasChild("Masa 1")){
                    imagebir.setClickable(false);
                    imagebir.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
                if (snapshot.hasChild("Masa 2")){
                    imageiki.setClickable(false);
                    imageiki.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
                if (snapshot.hasChild("Masa 3")){
                    imageuc.setClickable(false);
                    imageuc.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
                if (snapshot.hasChild("Masa 4")){
                    imagedort.setClickable(false);
                    imagedort.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
                if (snapshot.hasChild("Masa 5")){
                    imagebes.setClickable(false);
                    imagebes.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
                if (snapshot.hasChild("Masa 6")){
                    imagealti.setClickable(false);
                    imagealti.setBackground(getResources().getDrawable(R.drawable.kenarlik2));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        imagebir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 1");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 1");
                startActivity(intent);

            }
        });
        imageiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 2");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 2");
                startActivity(intent);

            }
        });
        imageuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 3");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 3");
                startActivity(intent);

            }
        });
        imagedort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 4");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 4");
                startActivity(intent);

            }
        });
        imagebes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 5");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 5");
                startActivity(intent);

            }
        });
        imagealti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child("Müşteriler").child(kullanici).child("Masa No").setValue("Masa 6");
                Intent intent = new Intent(Masa.this,MainActivity2.class);
                intent.putExtra("kullanici",kullanici);
                intent.putExtra("masa","Masa 6");
                startActivity(intent);

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