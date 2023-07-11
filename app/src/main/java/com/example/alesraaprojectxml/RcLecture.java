package com.example.alesraaprojectxml;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.RcCustomLectureNameBinding;

import java.util.List;

public class RcLecture extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<LectureModel> lectureModels;
    private RcCustomLectureNameBinding binding;

    public RcLecture(Context context, List<LectureModel> lectureModels) {
        this.context = context;
        this.lectureModels = lectureModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RcCustomLectureNameBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.binding.tvNameCourses.setText(lectureModels.get(position).getNameCourses());
        holder1.binding.tvName.setText(lectureModels.get(position).getName());
        holder1.binding.iconEmail.setOnClickListener(v -> {
            context.startActivity(new Intent(context, MassageTheAdmin.class));
        });
    }

    @Override
    public int getItemCount() {
        return lectureModels.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private RcCustomLectureNameBinding binding;

        public ViewHolder(RcCustomLectureNameBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
