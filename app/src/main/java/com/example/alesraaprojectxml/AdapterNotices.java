package com.example.alesraaprojectxml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.RvRecyclerviewDesignNoticesScreenBinding;

import java.util.ArrayList;

public class AdapterNotices extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ItemRecyclerNoticesScreen> arrayList;
    private RvRecyclerviewDesignNoticesScreenBinding binding;
    private ViewHandle viewHandle;



    public AdapterNotices(Context context, ArrayList<ItemRecyclerNoticesScreen> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RvRecyclerviewDesignNoticesScreenBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyAdapter myAdapter = (MyAdapter) holder;
        myAdapter.binding.tvNameCourse.setText(arrayList.get(position).getNameCourse());
        myAdapter.binding.tvDate.setText(arrayList.get(position).getDate());
        myAdapter.binding.tvDescription.setText(arrayList.get(position).getDescription());
        myAdapter.binding.image.setImageResource(arrayList.get(position).getImage());
        myAdapter.binding.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            boolean isChick = myAdapter.binding.checkBox.isChecked();

        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        RvRecyclerviewDesignNoticesScreenBinding binding;

        public MyAdapter(RvRecyclerviewDesignNoticesScreenBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface ViewHandle {
        void ClickHandle(boolean isChick, int pos);
    }
}
