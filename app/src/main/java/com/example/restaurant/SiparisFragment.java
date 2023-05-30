package com.example.restaurant;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.FontRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SiparisFragment extends Fragment {

    private DatabaseReference myRef;
    private ArrayList<String> urunler;
    private ArrayList<String> adetler;
    private ArrayList<String> fiyatlar;
    private ArrayList<String> yemekler;
    private ArrayList<String> arrayList1;
    private ArrayList<String> arrayList2;
    private ArrayList<String> arrayList3;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;
    private TextView txttoplam;
    private Button onayla;
    private String kullanici,masa;
    private int sum = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_siparis, container, false);
        myRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://adisyon-1af4b-default-rtdb.firebaseio.com/");

        urunler = new ArrayList<String>();
        adetler = new ArrayList<String>();
        fiyatlar = new ArrayList<String>();
        yemekler = new ArrayList<String>();
        arrayList1 = new ArrayList<String>();
        arrayList2 = new ArrayList<String>();
        arrayList3 = new ArrayList<String>();
        recyclerView = view.findViewById(R.id.recyclerView);
        txttoplam = view.findViewById(R.id.toplam);
        onayla = view.findViewById(R.id.onayla);

        //DATABASE DEN GİRİŞ YAPAN KULLANICININ MASA BİLGİLERİ ÇEKİLDİ
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
                        }
                        //YEMEKLER VE FİYATLARI ARRAYLİSTLERE ATILDI/////////////////
                        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                    String yiyecekTipi = childSnapshot.getKey();

                                    if(yiyecekTipi.equals("Corbalar")){
                                        for (DataSnapshot childSnapshot2 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot2.getKey();
                                            Object childData = childSnapshot2.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else if(yiyecekTipi.equals("Donerler")){
                                        for (DataSnapshot childSnapshot3 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot3.getKey();
                                            Object childData = childSnapshot3.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else if(yiyecekTipi.equals("Pideler")){
                                        for (DataSnapshot childSnapshot4 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot4.getKey();
                                            Object childData = childSnapshot4.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else if(yiyecekTipi.equals("Tatlilar")){
                                        for (DataSnapshot childSnapshot5 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot5.getKey();
                                            Object childData = childSnapshot5.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else if(yiyecekTipi.equals("İcecekler")){
                                        for (DataSnapshot childSnapshot6 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot6.getKey();
                                            Object childData = childSnapshot6.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else if(yiyecekTipi.equals("İzgaralar")){
                                        for (DataSnapshot childSnapshot7 : childSnapshot.getChildren()){
                                            String childKey = childSnapshot7.getKey();
                                            Object childData = childSnapshot7.getValue();
                                            yemekler.add(childKey);
                                            fiyatlar.add((String.valueOf(childData)));
                                        }
                                    }
                                    else{

                                    }
                                }
                                //SİPARİŞLERİN İSİM ADET VE FİYATLARI ARRAYLİSTLERE ATILDI
                                myRef.child("Siparişler").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                            String dugum = childSnapshot.getKey();
                                            if(dugum.equals(masa)) {
                                                for (DataSnapshot childSnapshot2 : childSnapshot.getChildren()) {
                                                    String childKey = childSnapshot2.getKey();
                                                    Object childData = childSnapshot2.getValue();
                                                    urunler.add(childKey);
                                                    adetler.add(String.valueOf(childData));
                                                }
                                                //URUNLER RECYCLERVİEWE ATILDI
                                                for (int i = 0;i<urunler.size();i++) {
                                                    int index = yemekler.indexOf(urunler.get(i));
                                                    arrayList1.add(urunler.get(i));
                                                    arrayList2.add(adetler.get(i));
                                                    arrayList3.add(String.valueOf(Integer.parseInt(fiyatlar.get(index))*Integer.parseInt(adetler.get(i))) +"₺");
                                                }
                                                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                                                recyclerView.setLayoutManager(linearLayoutManager);
                                                myAdapter = new MyAdapter(arrayList1,arrayList2,arrayList3);
                                                recyclerView.setAdapter(myAdapter);
                                                //SİLME BUTONU AKTİF EDİLDİ
                                                myRef.child("Siparişler").child(masa).addListenerForSingleValueEvent(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                        for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                                                            String yemek = childSnapshot.getKey();
                                                            Object adet = childSnapshot.getValue();
                                                            int index = yemekler.indexOf(yemek);
                                                            sum += Integer.parseInt(fiyatlar.get(index))*Integer.parseInt(String.valueOf(adet));
                                                        }
                                                        txttoplam.setText("Toplam Tutar: " + String.valueOf(sum) + "₺");
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError error) {

                                                    }
                                                });

                                                myAdapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(int position) {
                                                        if (Integer.parseInt(arrayList2.get(position)) > 1){
                                                            arrayList2.set(position,String.valueOf(Integer.parseInt(arrayList2.get(position))-1));
                                                            int index = yemekler.indexOf(arrayList1.get(position));
                                                            arrayList3.set(position,String.valueOf(Integer.parseInt(fiyatlar.get(index))*(Integer.parseInt(arrayList2.get(position))))+"₺");
                                                            myRef.child("Siparişler").child(masa).child(arrayList1.get(position)).setValue(Integer.parseInt(arrayList2.get(position)));
                                                            sum -= Integer.parseInt(fiyatlar.get(index));
                                                            txttoplam.setText("Toplam Tutar: " + String.valueOf(sum) + "₺");
                                                            myAdapter.notifyItemChanged(position);

                                                        }else if (Integer.parseInt(arrayList2.get(position)) == 1){
                                                            myRef.child("Siparişler").child(masa).child(arrayList1.get(position)).removeValue();
                                                            int index = yemekler.indexOf(arrayList1.get(position));
                                                            sum -= Integer.parseInt(fiyatlar.get(index));
                                                            txttoplam.setText("Toplam Tutar: " + String.valueOf(sum) + "₺");
                                                            arrayList1.remove(position);
                                                            arrayList2.remove(position);
                                                            arrayList3.remove(position);
                                                            myAdapter.notifyItemRemoved(position);
                                                        }
                                                    }
                                                });
                                            }
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

        onayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Siparişiniz Alındı", Toast.LENGTH_SHORT).show();
                myRef.child("Aktif Siparişler").child(masa).setValue(1);
                myRef.child("Siparişler").child(masa).removeValue();
                arrayList1.clear();
                arrayList2.clear();
                arrayList3.clear();
                recyclerView.setAdapter(myAdapter);
                txttoplam.setText("Toplam Tutar: 0₺");
            }
        });
        return view;
    }

}

