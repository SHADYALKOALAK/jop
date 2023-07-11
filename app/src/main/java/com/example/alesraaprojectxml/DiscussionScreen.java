package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityDiscussionScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class DiscussionScreen extends AppCompatActivity {
    private ActivityDiscussionScreenBinding binding;
    private Context context = DiscussionScreen.this;
    private List<CommentsModel> commentsModels;
    private Rc_Comment rc_comment;
    private DBase dBase;
    private String name;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDiscussionScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        commentsModels = new ArrayList<>();
        dBase = new DBase(context);
        rc_comment = new Rc_Comment(context, commentsModels);
        Cursor cursor = dBase.getComment();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String comment = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            commentsModels.add(new CommentsModel(nameProfile, comment));
            binding.tvName.setText(nameProfile);
        }
//       
        binding.rcComments.setAdapter(rc_comment);
        binding.rcComments.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        Cursor user = dBase.getUser();
        while (user.moveToNext()) {
            name = user.getString(user.getColumnIndex(DBase.COL_NAME));
        }

        binding.btnSend.setOnClickListener(v -> {
            String comment = binding.edComments.getText().toString().trim();
            if (comment.isEmpty()) {
                binding.edComments.setError("أضف تعليق من فضلك ");
            } else {
                commentsModels.add(new CommentsModel(name, comment));
                dBase.insertComment(new CommentsModel(name, comment));
                binding.edComments.setText("");
                rc_comment.notifyDataSetChanged();
            }
        });


        Cursor massage = dBase.getAdminDis();
        while (massage.moveToNext()) {
            String location = massage.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
            String dis = massage.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            binding.tvDis.setText(location);
            binding.tvMassage.setText(dis);
        }


        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "https://student.israa.edu.ps/", Toast.LENGTH_SHORT).show();
            }
        });
        binding.icNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Notices.class));
            }
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(c);
        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
        });
        binding.iconProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);

        });
        binding.iconEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomePageScreen.class));
            }
        });
        binding.iconArrow.setOnClickListener(v -> finish());

        binding.btnReply.setOnClickListener(v -> {
            String commentAdmin = binding.editReply.getText().toString().trim();
            if (commentAdmin.isEmpty()) {
                binding.editReply.setError("أدخل الرد من فضلك");
            } else {
                if (dBase.insertCommentAdmin(commentAdmin)) {
                    Toast.makeText(context, "تم إضافة الرد", Toast.LENGTH_SHORT).show();
                    binding.editReply.setText("");
                }
            }
        });


    }


}