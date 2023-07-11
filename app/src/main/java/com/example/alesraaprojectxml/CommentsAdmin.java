package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.alesraaprojectxml.databinding.ActivityCommentsAdminBinding;

import java.util.ArrayList;

public class CommentsAdmin extends AppCompatActivity {
    private Context context = CommentsAdmin.this;
    private ArrayList<ItemCommentsAdmin> arrayList;
    private AdapterCommentsAdmin adapterCommentsAdmin;
    private DBase dBase;
    private String nameProfile;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCommentsAdminBinding binding;
        binding = ActivityCommentsAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        arrayList = new ArrayList<>();
        dBase = new DBase(context);

        adapterCommentsAdmin = new AdapterCommentsAdmin(context, arrayList);
        binding.rv.setAdapter(adapterCommentsAdmin);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.rv.setLayoutManager(linearLayoutManager);
//        Cursor cursor = dBase.getUser();
//        while (cursor.moveToNext()) {
//            nameProfile = cursor.getString(cursor.getColumnIndex(DBase.COL_NAME));
//            binding.tvName.setText(nameProfile);
//        }

        Cursor commentAdmin = dBase.getCommentAdmin();
        while (commentAdmin.moveToNext()) {
            @SuppressLint("Range") String comment = commentAdmin.getString(commentAdmin.getColumnIndex(commentAdmin.getColumnName(1)));
            arrayList.add(new ItemCommentsAdmin(nameProfile, comment));
        }


        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, Comments_Screen.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconMassage.setOnClickListener(v -> {
            startActivity(new Intent(context, MassagesStudentWethAdmin.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, Admin_1.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });

    }
}