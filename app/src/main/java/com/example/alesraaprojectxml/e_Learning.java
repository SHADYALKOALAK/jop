package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityElearningSBinding;

import java.util.ArrayList;

public class e_Learning extends AppCompatActivity {
    private Context context = e_Learning.this;
    private DBase dBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityElearningSBinding binding;
        binding = ActivityElearningSBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dBase = new DBase(context);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");
        binding.tvNameCourse.setText(name);
        binding.tvNumberOfCourse.setText(id);
        binding.iconArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomePageScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
        Cursor cursor = dBase.getUser();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(DBase.COL_NAME));
            binding.tvName.setText(nameProfile);
        }
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent();
                c.setAction(Intent.ACTION_VIEW);
                c.setData(Uri.parse("https://student.israa.edu.ps/"));
                startActivity(c);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.icNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Notices.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(c);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconProfileScreen.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomePageScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,ViedoScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,FileScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvExportHomeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HomeWorkScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvExportHomeWork1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,HomeWorkScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,ExamScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvTook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,DiscussionScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "هذه الصفحة غير متوفرة حالياً", Toast.LENGTH_SHORT).show();
            }
        });








    }

}