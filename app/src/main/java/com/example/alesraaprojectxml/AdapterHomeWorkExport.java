package com.example.alesraaprojectxml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.DailogMarksBinding;
import com.example.alesraaprojectxml.databinding.RvExporthomworkscreendesignBinding;
import com.example.alesraaprojectxml.databinding.RvRecyclerviewDesignNoticesScreenBinding;

import java.util.ArrayList;

public class AdapterHomeWorkExport extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private ArrayList<ItemRvHomeWorkExport> arrayList;
    private RvExporthomworkscreendesignBinding binding;
    private ViewHandle_inter viewHandle_inter;
    private DailogMarksBinding dailogMarks;
    private DBase dBase;
    private AlertDialog dialog;


    public AdapterHomeWorkExport(Context context, ArrayList<ItemRvHomeWorkExport> arrayList, ViewHandle_inter viewHandle_inter) {
        this.context = context;
        this.arrayList = arrayList;
        this.viewHandle_inter = viewHandle_inter;
        dBase = new DBase(context);
        //

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RvExporthomworkscreendesignBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyAdapter(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyAdapter myAdapter = (MyAdapter) holder;
        myAdapter.binding.tvNameCourse.setText(arrayList.get(position).getNameCourse());
        myAdapter.binding.tvNameStudent.setText(arrayList.get(position).getName());
//        binding.getRoot().setOnClickListener(v -> viewHandle_inter.ClickHandle(position));


        binding.getRoot().setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            dailogMarks = DailogMarksBinding.inflate(LayoutInflater.from(context));
            builder.setView(dailogMarks.getRoot());
            dailogMarks.imageAdd.setOnClickListener(v1 -> {
                String mark = dailogMarks.editMarks.getText().toString().trim();
                int mark1 = Integer.parseInt(mark);
                if (mark.isEmpty()) {
                    dailogMarks.editMarks.setError("أدخل درجة الطالب ");
                } else if (mark1 > 10) {
                    dailogMarks.editMarks.setError("يجب عليك إدخال العلامة من 10 ");
                } else {
                    if (dBase.insertMarkAdmin(mark, arrayList.get(position).getNameCourse())) {
                        Toast.makeText(context, " تم إرسال العلامة", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }
            });


            dialog = builder.create();

            dialog.show();
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyAdapter extends RecyclerView.ViewHolder {
        RvExporthomworkscreendesignBinding binding;

        public MyAdapter(RvExporthomworkscreendesignBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public interface ViewHandle_inter {
        void ClickHandle(int pos);
    }

}
