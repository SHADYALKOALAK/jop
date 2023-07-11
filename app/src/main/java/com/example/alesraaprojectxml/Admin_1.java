package com.example.alesraaprojectxml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityAdmin1Binding;
import com.example.alesraaprojectxml.databinding.CustomdailogBinding;

public class Admin_1 extends AppCompatActivity {
    private ActivityAdmin1Binding binding;
    private Context context = Admin_1.this;
    private AlertDialog alertDialog;
    private CustomdailogBinding customdailogBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdmin1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                customdailogBinding = CustomdailogBinding.inflate(getLayoutInflater());
                builder.setView(customdailogBinding.getRoot());
                customdailogBinding.tvMassage.setText("هل أنت متأكد من تسجيل الخروج");
                customdailogBinding.tvDis.setText("رسالة تأكيد");
                customdailogBinding.btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "تم تسجيل الخروج بنجاح", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,LoginScreen.class));
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    }
                });
                customdailogBinding.btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog = builder.create();
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        });






        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, Comments_Screen.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconComment.setOnClickListener(v -> {
            startActivity(new Intent(context, CommentsAdmin.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconMassage.setOnClickListener(v -> {
            startActivity(new Intent(context, MassagesStudentWethAdmin.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.imageExportFile.setOnClickListener(v -> {
            Intent intent = new Intent(context, UploodScreen.class);
            intent.putExtra("flag",1);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        });
        binding.imagePost.setOnClickListener(v -> {
            Intent intent = new Intent(context, UploodScreen.class);
            intent.putExtra("flag",2);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        });
        binding.imageHomework.setOnClickListener(v -> {
            Intent intent = new Intent(context, UploodScreen.class);
            intent.putExtra("flag",3);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        });
        binding.imageSpeacke.setOnClickListener(v -> {
            Intent intent = new Intent(context, UploodScreen.class);
            intent.putExtra("flag",4);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

        });
        binding.imageVideo.setOnClickListener(v -> {
            Intent intent = new Intent(context, UploodScreen.class);
            intent.putExtra("flag",5);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
    }
}