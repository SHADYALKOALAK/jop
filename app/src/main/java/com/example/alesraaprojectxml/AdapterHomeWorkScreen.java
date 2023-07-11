package com.example.alesraaprojectxml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.alesraaprojectxml.databinding.RvHomeworkdescriptionBinding;

import java.util.ArrayList;

public class AdapterHomeWorkScreen extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<ItemRvHomeWork> arrayList;
    private Context context;
    private RvHomeworkdescriptionBinding binding;

    public AdapterHomeWorkScreen(ArrayList<ItemRvHomeWork> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RvHomeworkdescriptionBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        myViewHolder.binding.marks.setText(arrayList.get(position).getMark());
        myViewHolder.binding.nameHomework.setText(arrayList.get(position).getNameHomWork());




    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    private class MyViewHolder extends RecyclerView.ViewHolder {
        private RvHomeworkdescriptionBinding binding;

        public MyViewHolder(RvHomeworkdescriptionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

}
