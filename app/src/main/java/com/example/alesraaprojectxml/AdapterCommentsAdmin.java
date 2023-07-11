package com.example.alesraaprojectxml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.RvCommentsDesignBinding;

import java.util.ArrayList;

public class AdapterCommentsAdmin extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<ItemCommentsAdmin> arrayList;
    RvCommentsDesignBinding binding;

    public AdapterCommentsAdmin(Context context, ArrayList<ItemCommentsAdmin> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        //

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RvCommentsDesignBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyAdapter myAdapter= (MyAdapter) holder;
        myAdapter.binding.tvNameStudent.setText(arrayList.get(position).getName());
        myAdapter.binding.tvComments.setText(arrayList.get(position).getComments());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class MyAdapter extends RecyclerView.ViewHolder{
        RvCommentsDesignBinding binding;

        public MyAdapter(  RvCommentsDesignBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
