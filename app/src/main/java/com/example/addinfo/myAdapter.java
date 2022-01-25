package com.example.addinfo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.holder> {

    model data[];

    public myAdapter(model[] data) {
        this.data = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layout = LayoutInflater.from(parent.getContext());
        View view = layout.inflate(R.layout.row ,parent , false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.name.setText(data[position].getName());
        holder.erNumber.setText(data[position].getErNumber());
        holder.Email.setText(data[position].getEmail());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class holder extends RecyclerView.ViewHolder{


        TextView name , erNumber , Email;
        public holder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            erNumber = (TextView) itemView.findViewById(R.id.er);
            Email = (TextView) itemView.findViewById(R.id.mail);

        }
    }
}
