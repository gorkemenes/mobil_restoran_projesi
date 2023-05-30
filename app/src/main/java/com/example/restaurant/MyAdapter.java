package com.example.restaurant;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<String> arrayList1;
    private ArrayList<String> arrayList2;
    private ArrayList<String> arrayList3;
    private OnItemClickListener listener;

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        listener = clickListener;
    }

    public MyAdapter(ArrayList<String> arrayList1, ArrayList<String> arrayList2, ArrayList<String> arrayList3) {
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.arrayList3 = arrayList3;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.urun,parent,false);

        return new MyViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        holder.urun.setText(arrayList1.get(position).toString());
        holder.adet.setText(arrayList2.get(position).toString());
        holder.fiyat.setText(arrayList3.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView urun,adet,fiyat;
        private ImageView azalt;

        public MyViewHolder(@NonNull View itemView ,OnItemClickListener listener) {
            super(itemView);
            urun = itemView.findViewById(R.id.urun);
            adet = itemView.findViewById(R.id.adet);
            fiyat = itemView.findViewById(R.id.fiyat);
            azalt = itemView.findViewById(R.id.azalt);

            azalt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });

        }
    }
}
