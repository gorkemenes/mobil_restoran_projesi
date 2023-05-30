package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private EditText kullanici_kayit_text,sifre_kayit_text,sifretekrar_kayit_text,email_kayit_text;
    private Button kayit_btn,hesabimvar_btn;

    private String ad,sifre,sifretekrar,email;

    private DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        kullanici_kayit_text = findViewById(R.id.kullanici_kayit_text);
        sifre_kayit_text = findViewById(R.id.sifre_kayit_text);
        sifretekrar_kayit_text = findViewById(R.id.sifretekrar_kayit_text);
        email_kayit_text = findViewById(R.id.email_kayit_text);
        kayit_btn = findViewById(R.id.kayit_btn);
        hesabimvar_btn = findViewById(R.id.hesabimvar_btn);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");



        kayit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ad = kullanici_kayit_text.getText().toString();
                sifre = sifre_kayit_text.getText().toString();
                sifretekrar =  sifretekrar_kayit_text.getText().toString();
                email = email_kayit_text.getText().toString();

                if(TextUtils.isEmpty(sifre) || TextUtils.isEmpty(ad) || TextUtils.isEmpty(sifretekrar)){
                    Toast.makeText(RegisterActivity.this, "Lütfen tüm alanları doldurun", Toast.LENGTH_SHORT).show();
                }
                if(!sifre.equals(sifretekrar)){
                    Toast.makeText(RegisterActivity.this, "Şifreler uyuşmuyor", Toast.LENGTH_SHORT).show();
                }
                else{
                    myRef.child("Müşteriler").child(ad).child("isim").setValue(ad);
                    myRef.child("Müşteriler").child(ad).child("sifre").setValue(sifre);
                    myRef.child("Müşteriler").child(ad).child("email").setValue(email);
                    Toast.makeText(RegisterActivity.this, "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }
            }
        });

        hesabimvar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
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