package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityHomeWorkDescriptionBinding;

import java.util.ArrayList;

public class HomeWorkDescription extends AppCompatActivity {
    private ArrayList<ItemRvHomeWork> arrayList;
    private Context context = HomeWorkDescription.this;
    private AdapterHomeWorkScreen adapter;
    private DBase dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityHomeWorkDescriptionBinding binding;
        binding = ActivityHomeWorkDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayList = new ArrayList<>();
        dBase = new DBase(context);

        Cursor marks = dBase.getMarkAdmin();
        while (marks.moveToNext()) {
            @SuppressLint("Range") String mark = marks.getString(marks.getColumnIndex(marks.getColumnName(1)));
            @SuppressLint("Range") String name = marks.getString(marks.getColumnIndex(marks.getColumnName(2)));
            arrayList.add(new ItemRvHomeWork(name, mark));

        }


        adapter = new AdapterHomeWorkScreen(arrayList, context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.rv.setAdapter(adapter);
        binding.rv.setLayoutManager(linearLayoutManager);

        binding.imageProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(intent);
        });
        binding.iconProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
        });
        binding.iconArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}