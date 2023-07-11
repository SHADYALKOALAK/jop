package com.example.alesraaprojectxml;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.alesraaprojectxml.databinding.RvdesignmassageswithadminBinding;

import java.util.ArrayList;

public class AdapterMassageStudentWithAdmin extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
   private ArrayList<ItemMassageStudentWithAdmin>arrayList;
   private Context context;
   private RvdesignmassageswithadminBinding binding;

    public AdapterMassageStudentWithAdmin(ArrayList<ItemMassageStudentWithAdmin> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
        //
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=RvdesignmassageswithadminBinding.inflate(LayoutInflater.from(context),parent,false);
        return new MyAdapter(binding) ;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyAdapter myAdapter= (MyAdapter) holder;
        myAdapter.binding.tvNameStudent.setText(arrayList.get(position).getNameStudent());
        myAdapter.binding.tvComments.setText(arrayList.get(position).getMassage());
        myAdapter.binding.tvTitleMassage.setText(arrayList.get(position).getTitleMassage());
        myAdapter.binding.btnReply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,ReplyAdmin.class));
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class MyAdapter extends RecyclerView.ViewHolder{
        RvdesignmassageswithadminBinding binding;

        public MyAdapter(  RvdesignmassageswithadminBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
