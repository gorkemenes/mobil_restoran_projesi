package com.example.restaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class MenuFragment extends Fragment {



    private ImageButton corba,pide,doner,izgara,tatli,icecek;
    private ScrollView corbapanel,pidepanel,donerpanel,izgarapanel,tatlipanel,icecekpanel;
    private Button corba1,corba2,corba3,corba4,pide1,pide2,pide3,pide4,doner1,doner2,doner3,doner4,
            izgara1,izgara2,izgara3,izgara4,tatli1,tatli2,tatli3,tatli4,
            icecek1,icecek2,icecek3,icecek4,icecek5,icecek6,icecek7,icecek8;
    private DatabaseReference myRef;
    private TextView baslik;
    private String kullanici,masa;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");

        myRef.child("Giriş Yapan Kullanıcı").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild("İsim")){
                    kullanici = snapshot.child("İsim").getValue(String.class);
                }
                myRef.child("Müşteriler").child(kullanici).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Masa No")){
                            masa = snapshot.child("Masa No").getValue(String.class);
                            baslik.setText(masa);
                        }
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

        corba = view.findViewById(R.id.corba);
        pide = view.findViewById(R.id.pide);
        doner = view.findViewById(R.id.doner);
        izgara = view.findViewById(R.id.izgara);
        tatli = view.findViewById(R.id.tatli);
        icecek = view.findViewById(R.id.icecek);
        corbapanel = view.findViewById(R.id.corbapanel);
        pidepanel = view.findViewById(R.id.pidepanel);
        donerpanel = view.findViewById(R.id.donerpanel);
        izgarapanel = view.findViewById(R.id.izgarapanel);
        tatlipanel = view.findViewById(R.id.tatlipanel);
        icecekpanel = view.findViewById(R.id.icecekpanel);
        corba1 = view.findViewById(R.id.corba1);
        corba2 = view.findViewById(R.id.corba2);
        corba3 = view.findViewById(R.id.corba3);
        corba4 = view.findViewById(R.id.corba4);
        pide1 = view.findViewById(R.id.pide1);
        pide2 = view.findViewById(R.id.pide2);
        pide3 = view.findViewById(R.id.pide3);
        pide4 = view.findViewById(R.id.pide4);
        doner1 = view.findViewById(R.id.doner1);
        doner2 = view.findViewById(R.id.doner2);
        doner3 = view.findViewById(R.id.doner3);
        doner4 = view.findViewById(R.id.doner4);
        izgara1 = view.findViewById(R.id.izgara1);
        izgara2 = view.findViewById(R.id.izgara2);
        izgara3 = view.findViewById(R.id.izgara3);
        izgara4 = view.findViewById(R.id.izgara4);
        tatli1 = view.findViewById(R.id.tatli1);
        tatli2 = view.findViewById(R.id.tatli2);
        tatli3 = view.findViewById(R.id.tatli3);
        tatli4 = view.findViewById(R.id.tatli4);
        icecek1 = view.findViewById(R.id.icecek1);
        icecek2 = view.findViewById(R.id.icecek2);
        icecek3 = view.findViewById(R.id.icecek3);
        icecek4 = view.findViewById(R.id.icecek4);
        icecek5 = view.findViewById(R.id.icecek5);
        icecek6 = view.findViewById(R.id.icecek6);
        icecek7 = view.findViewById(R.id.icecek7);
        icecek8 = view.findViewById(R.id.icecek8);
        baslik = view.findViewById(R.id.baslik);
        corbapanel.setVisibility(View.VISIBLE);
        pidepanel.setVisibility(View.INVISIBLE);
        donerpanel.setVisibility(View.INVISIBLE);
        izgarapanel.setVisibility(View.INVISIBLE);
        tatlipanel.setVisibility(View.INVISIBLE);
        icecekpanel.setVisibility(View.INVISIBLE);

        corba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.VISIBLE);
                pidepanel.setVisibility(View.INVISIBLE);
                donerpanel.setVisibility(View.INVISIBLE);
                izgarapanel.setVisibility(View.INVISIBLE);
                tatlipanel.setVisibility(View.INVISIBLE);
                icecekpanel.setVisibility(View.INVISIBLE);
            }
        });

        pide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.INVISIBLE);
                pidepanel.setVisibility(View.VISIBLE);
                donerpanel.setVisibility(View.INVISIBLE);
                izgarapanel.setVisibility(View.INVISIBLE);
                tatlipanel.setVisibility(View.INVISIBLE);
                icecekpanel.setVisibility(View.INVISIBLE);

            }
        });

        doner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.INVISIBLE);
                pidepanel.setVisibility(View.INVISIBLE);
                donerpanel.setVisibility(View.VISIBLE);
                izgarapanel.setVisibility(View.INVISIBLE);
                tatlipanel.setVisibility(View.INVISIBLE);
                icecekpanel.setVisibility(View.INVISIBLE);
            }
        });

        izgara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.INVISIBLE);
                pidepanel.setVisibility(View.INVISIBLE);
                donerpanel.setVisibility(View.INVISIBLE);
                izgarapanel.setVisibility(View.VISIBLE);
                tatlipanel.setVisibility(View.INVISIBLE);
                icecekpanel.setVisibility(View.INVISIBLE);
            }
        });

        tatli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.INVISIBLE);
                pidepanel.setVisibility(View.INVISIBLE);
                donerpanel.setVisibility(View.INVISIBLE);
                izgarapanel.setVisibility(View.INVISIBLE);
                tatlipanel.setVisibility(View.VISIBLE);
                icecekpanel.setVisibility(View.INVISIBLE);
            }
        });

        icecek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                corbapanel.setVisibility(View.INVISIBLE);
                pidepanel.setVisibility(View.INVISIBLE);
                donerpanel.setVisibility(View.INVISIBLE);
                izgarapanel.setVisibility(View.INVISIBLE);
                tatlipanel.setVisibility(View.INVISIBLE);
                icecekpanel.setVisibility(View.VISIBLE);


            }
        });

        corba1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Mercimek Çorbası")){
                            int adet = snapshot.child("Mercimek Çorbası").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Mercimek Çorbası").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Mercimek Çorbası").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


        corba2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Yayla Çorbası")){
                            int adet = snapshot.child("Yayla Çorbası").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Yayla Çorbası").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Yayla Çorbası").setValue(1);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        corba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Ezogelin Çorbası")){
                            int adet = snapshot.child("Ezogelin Çorbası").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Ezogelin Çorbası").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Ezogelin Çorbası").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        corba4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Domates Çorbası")){
                            int adet = snapshot.child("Domates Çorbası").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Domates Çorbası").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Domates Çorbası").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        pide1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kıymalı Pide")){
                            int adet = snapshot.child("Kıymalı Pide").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kıymalı Pide").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kıymalı Pide").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        pide2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kaşarlı Pide")){
                            int adet = snapshot.child("Kaşarlı Pide").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kaşarlı Pide").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kaşarlı Pide").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        pide3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kuşbaşılı Pide")){
                            int adet = snapshot.child("Kuşbaşılı Pide").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kuşbaşılı Pide").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kuşbaşılı Pide").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        pide4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Karışık Pide")){
                            int adet = snapshot.child("Karışık Pide").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Karışık Pide").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Karışık Pide").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        doner1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Et Döner")){
                            int adet = snapshot.child("Et Döner").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Et Döner").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Et Döner").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        doner2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Tavuk Döner")){
                            int adet = snapshot.child("Tavuk Döner").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Tavuk Döner").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Tavuk Döner").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        doner3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Et İskender")){
                            int adet = snapshot.child("Et İskender").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Et İskender").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Et İskender").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        doner4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Tavuk İskender")){
                            int adet = snapshot.child("Tavuk İskender").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Tavuk İskender").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Tavuk İskender").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        izgara1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Karışık Izgara")){
                            int adet = snapshot.child("Karışık Izgara").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Karışık Izgara").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Karışık Izgara").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        izgara2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Köfte Izgara")){
                            int adet = snapshot.child("Köfte Izgara").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Köfte Izgara").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Köfte Izgara").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        izgara3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Tavuk Izgara")){
                            int adet = snapshot.child("Tavuk Izgara").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Tavuk Izgara").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Tavuk Izgara").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        izgara4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Et Izgara")){
                            int adet = snapshot.child("Et Izgara").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Et Izgara").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Et Izgara").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        tatli1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Sütlaç")){
                            int adet = snapshot.child("Sütlaç").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Sütlaç").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Sütlaç").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        tatli2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kadayıf")){
                            int adet = snapshot.child("Kadayıf").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kadayıf").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kadayıf").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        tatli3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Künefe")){
                            int adet = snapshot.child("Künefe").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Künefe").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Künefe").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        tatli4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kazandibi")){
                            int adet = snapshot.child("Kazandibi").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kazandibi").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kazandibi").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Su")){
                            int adet = snapshot.child("Su").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Su").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Su").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Ayran")){
                            int adet = snapshot.child("Ayran").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Ayran").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Ayran").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Çay")){
                            int adet = snapshot.child("Çay").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Çay").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Çay").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Kola")){
                            int adet = snapshot.child("Kola").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Kola").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Kola").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Fanta")){
                            int adet = snapshot.child("Fanta").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Fanta").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Fanta").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Sprite")){
                            int adet = snapshot.child("Sprite").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Sprite").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Sprite").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("İce Tea")){
                            int adet = snapshot.child("İce Tea").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("İce Tea").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("İce Tea").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

        icecek8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.hasChild("Soda")){
                            int adet = snapshot.child("Soda").getValue(Integer.class);
                            adet++;
                            myRef.child("Siparişler").child(masa).child("Soda").setValue(adet);

                        }else {
                            myRef.child("Siparişler").child(masa).child("Soda").setValue(1);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        return view;
    }
}