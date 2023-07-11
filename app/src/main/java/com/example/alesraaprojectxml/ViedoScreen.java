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

import com.example.alesraaprojectxml.databinding.ActivityViedoScreenBinding;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ViedoScreen extends AppCompatActivity {
    private ActivityViedoScreenBinding binding;
    private Context context = ViedoScreen.this;
    private List<CommentsModel> commentsModels;
    private Rc_Comment rc_comment;
    private DBase dataBase;
    @SuppressLint("Range")
    private String name;
    private String path ="";

    @SuppressLint({"Range", "NotifyDataSetChanged"})
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViedoScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        commentsModels = new ArrayList<>();
        dataBase = new DBase(context);
        rc_comment = new Rc_Comment(context, commentsModels);

        Cursor vied = dataBase.getViedon();
        while (vied.moveToNext()) {
            path = vied.getString(vied.getColumnIndex(vied.getColumnName(1)));
            String title = vied.getString(vied.getColumnIndex(vied.getColumnName(2)));
            String dis = vied.getString(vied.getColumnIndex(vied.getColumnName(3)));
            binding.tvNameCourses.setText(title);
            binding.tvDis.setText(dis);
        }
        Cursor cursor = dataBase.getComment();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String comment = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            commentsModels.add(new CommentsModel(nameProfile, comment));
        }
        binding.rcComments.setAdapter(rc_comment);
        binding.rcComments.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        Cursor user = dataBase.getUser();
        while (user.moveToNext()) {
            name = user.getString(user.getColumnIndex(DBase.COL_NAME));
        }


        binding.btnSend.setOnClickListener(v -> {
            String comment = binding.edComments.getText().toString().trim();
            if (comment.isEmpty()) {
                binding.edComments.setError("أضف تعليق من فضلك ");
            } else {
                commentsModels.add(new CommentsModel(name, comment));
                dataBase.insertComment(new CommentsModel(name, comment));
                binding.edComments.setText("");
                rc_comment.notifyDataSetChanged();
            }
        });
        binding.iconArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, e_Learning.class));

            }
        });
        binding.you.setOnClickListener(v -> {
            if (!path.equals(null) && path.contains("http")) {
                Intent facebook = new Intent();
                facebook.setAction(Intent.ACTION_VIEW);
                facebook.setData(Uri.parse(path));
                startActivity(facebook);
            }else {
                Toast.makeText(context, "لم يقم المدرس بإدراج أي رابط ", Toast.LENGTH_SHORT).show();
            }

        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent();
                c.setAction(Intent.ACTION_VIEW);
                c.setData(Uri.parse("https://student.israa.edu.ps/"));
                startActivity(c);
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




    }
}