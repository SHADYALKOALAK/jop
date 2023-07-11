package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.alesraaprojectxml.databinding.ActivityMassagesStudentWethAdminBinding;

import java.util.ArrayList;

public class MassagesStudentWethAdmin extends AppCompatActivity {
    private ArrayList<ItemMassageStudentWithAdmin> arrayList;
    private Context context = MassagesStudentWethAdmin.this;
    private AdapterMassageStudentWithAdmin adapterMassageStudentWithAdmin;
    private DBase dBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMassagesStudentWethAdminBinding binding;
        binding = ActivityMassagesStudentWethAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayList = new ArrayList<>();
        dBase = new DBase(context);
        adapterMassageStudentWithAdmin = new AdapterMassageStudentWithAdmin(arrayList, context);
//
        Cursor cursor = dBase.getMassage();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(DBase.COL_NAME_PERSONAL));
            @SuppressLint("Range") String massage = cursor.getString(cursor.getColumnIndex(DBase.COL_MASSAGE));
            @SuppressLint("Range") String titelMassage = cursor.getString(cursor.getColumnIndex(DBase.COL_TITlE_MASSAGE));
            arrayList.add(new ItemMassageStudentWithAdmin(nameProfile, titelMassage, massage));
            binding.tvName.setText(nameProfile);
        }
        binding.rv.setAdapter(adapterMassageStudentWithAdmin);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.rv.setLayoutManager(linearLayoutManager);

        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, Comments_Screen.class));
        });
        binding.iconComment.setOnClickListener(v -> {
            startActivity(new Intent(context, CommentsAdmin.class));
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Admin_1.class));
            }
        });
    }
}