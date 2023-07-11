package com.example.alesraaprojectxml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.RcCustomCoursesBinding;
import com.google.android.material.transition.Hold;


import java.util.List;

public class Rc_courses extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CoursesModel> coursesModels;
    private RcCustomCoursesBinding binding;
    Handle click;


    public Rc_courses(Context context, List<CoursesModel> coursesModels, Handle click) {
        this.context = context;
        this.coursesModels = coursesModels;
        this.click = click;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RcCustomCoursesBinding.inflate(LayoutInflater.from(context), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.binding.iconCourses.setImageResource(coursesModels.get(position).getImage());
        myViewHolder.binding.tvNameCourses.setText(coursesModels.get(position).getNameCourses());
        myViewHolder.binding.tvIdCourses.setText(coursesModels.get(position).getIdCourses());
        myViewHolder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, e_Learning.class);
                intent.putExtra("name", coursesModels.get(position).getNameCourses());
                intent.putExtra("id", coursesModels.get(position).getIdCourses());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return coursesModels.size();
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private RcCustomCoursesBinding binding;

        public MyViewHolder(RcCustomCoursesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    public interface Handle {
        public void clickHandle(int position, String nameCourse, String idCourse);


    }
}
