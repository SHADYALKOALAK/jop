package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alesraaprojectxml.databinding.ActivitySureSend2Binding;
import com.example.alesraaprojectxml.databinding.ActivitySureSendBinding;

public class SureSend_2 extends AppCompatActivity {
     Context context=SureSend_2.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySureSend2Binding binding;
        binding=ActivitySureSend2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, Comments_Screen.class));
        });
        binding.iconComment.setOnClickListener(v -> {
            startActivity(new Intent(context, CommentsAdmin.class));
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,Admin_1.class));
            }
        });





    }
}