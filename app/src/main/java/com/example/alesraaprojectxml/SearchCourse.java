package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.alesraaprojectxml.databinding.ActivitySearchCourseBinding;
import com.example.alesraaprojectxml.databinding.ActivitySureSendBinding;

public class SearchCourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySearchCourseBinding binding;
        binding=ActivitySearchCourseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}