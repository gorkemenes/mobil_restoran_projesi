package com.example.restaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    protected EditText kullanici_giris_text,sifre_giris_text;
    private Button giris_btn,hesabimyok_btn;

    private DatabaseReference myRef;

    private String kullanici,sifre;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        kullanici_giris_text = findViewById(R.id.kullanici_giris_text);
        sifre_giris_text = findViewById(R.id.sifre_giris_text);
        giris_btn = findViewById(R.id.giris_btn);
        hesabimyok_btn = findViewById(R.id.hesabimyok_btn);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");



        giris_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kullanici = kullanici_giris_text.getText().toString();
                sifre = sifre_giris_text.getText().toString();


                if (TextUtils.isEmpty(kullanici) || TextUtils.isEmpty(sifre)) {
                    Toast.makeText(MainActivity.this, "email ya da şifre girin", Toast.LENGTH_SHORT).show();
                } else{

                    myRef.child("Müşteriler").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if(snapshot.hasChild(kullanici)){

                                final String gelensifre = snapshot.child(kullanici).child("sifre").getValue(String.class);

                                if(gelensifre.equals(sifre)){
                                    Toast.makeText(MainActivity.this, "Giriş Başarılı", Toast.LENGTH_SHORT).show();
                                    myRef.child("Giriş Yapan Kullanıcı").child("İsim").setValue(kullanici);
                                    Intent intent = new Intent(MainActivity.this,Masa.class);
                                    intent.putExtra("mesaj",kullanici);
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(MainActivity.this, "Yanlış Şifre !", Toast.LENGTH_SHORT).show();
                                }

                            }else{
                                Toast.makeText(MainActivity.this, "Yanlış Kullanıcı adı!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        hesabimyok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
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