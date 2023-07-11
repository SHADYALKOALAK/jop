package com.example.alesraaprojectxml;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.RcCustomCommentsBinding;

import java.util.List;

public class Rc_Comment extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CommentsModel> commentsModels;
    private RcCustomCommentsBinding binding;

    public Rc_Comment(Context context, List<CommentsModel> commentsModels) {
        this.context = context;
        this.commentsModels = commentsModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = RcCustomCommentsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        holder1.binding.tvName.setText(commentsModels.get(position).getName());
        holder1.binding.tvComments.setText(commentsModels.get(position).getComment());


    }

    @Override
    public int getItemCount() {
        return commentsModels.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private RcCustomCommentsBinding binding;

        public ViewHolder(RcCustomCommentsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
