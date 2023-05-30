package com.example.restaurant;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfilFragment extends Fragment {

    private TextView main_adsoyad_text,basharf_text,adsoyad_profil_text,email_profil_text,sifre_profil_text;
    private String adsoyad,email,sifre;
    private ImageButton kapat;
    private DatabaseReference myRef;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        main_adsoyad_text = view.findViewById(R.id.main_adsoyad_text);
        basharf_text = view.findViewById(R.id.basharf_text);
        adsoyad_profil_text = view.findViewById(R.id.adsoyad_profil_text);
        email_profil_text = view.findViewById(R.id.email_profil_text);
        sifre_profil_text =  view.findViewById(R.id.sifre_profil_text);
        kapat = view.findViewById(R.id.kapat);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");

        myRef.child("Giriş Yapan Kullanıcı").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                adsoyad = snapshot.child("İsim").getValue(String.class);
                myRef.child("Müşteriler").child(adsoyad).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        email = snapshot.child("email").getValue(String.class);
                        sifre = snapshot.child("sifre").getValue(String.class);

                        basharf_text.setText(adsoyad.substring(0,1).toUpperCase());
                        main_adsoyad_text.setText(adsoyad);
                        adsoyad_profil_text.setText(adsoyad);
                        email_profil_text.setText(email);
                        sifre_profil_text.setText(sifre);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        kapat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Giriş Yapan Kullanıcı").removeValue();
                myRef.child("Müşteriler").child(adsoyad).child("Masa No").removeValue();
                Intent intent = new Intent(getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}