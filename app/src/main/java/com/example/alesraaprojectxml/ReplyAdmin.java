package com.example.alesraaprojectxml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.alesraaprojectxml.databinding.ActivityReplyAdminBinding;
import com.example.alesraaprojectxml.databinding.CustomdailogBinding;

public class ReplyAdmin extends AppCompatActivity {
    private CustomdailogBinding customDialog;
    Context context = ReplyAdmin.this;
    private AlertDialog dialog;
    private DBase dBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityReplyAdminBinding binding;
        binding = ActivityReplyAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dBase = new DBase(context);
        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String massage = binding.editNamePerson.getText().toString().trim();
                if (massage.isEmpty()) {
                    binding.editNamePerson.setError("من فضلك أدخل نص الرسالة أولاً");
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    customDialog = CustomdailogBinding.inflate(getLayoutInflater());
                    builder.setView(customDialog.getRoot());
                    customDialog.btnYes.setOnClickListener(v1 -> {
                        startActivity(new Intent(context, SureSend_2.class));
                        dBase.insertNotifications("تم الرد من قبل المحاضر" +massage);
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    });
                    customDialog.btnNo.setOnClickListener(v12 -> {
                        dialog.dismiss();
                    });
                    dialog = builder.create();
                    dialog.setCancelable(false);
                    dialog.show();


                }
            }
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}