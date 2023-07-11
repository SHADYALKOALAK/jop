package com.example.alesraaprojectxml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityMassageTheAdminBinding;
import com.example.alesraaprojectxml.databinding.CustomdailogBinding;

import java.util.ArrayList;
import java.util.List;

public class MassageTheAdmin extends AppCompatActivity {
    private ActivityMassageTheAdminBinding binding;
    private Context context = MassageTheAdmin.this;
    private AdapterMassageStudentWithAdmin admin;
    private ArrayList<ItemMassageStudentWithAdmin> list;
    private CustomdailogBinding customDialog;
    private AlertDialog dialog;
    private DBase dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMassageTheAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        list = new ArrayList<>();
        dBase = new DBase(context);
        admin = new AdapterMassageStudentWithAdmin(list,context);


        binding.btnSend.setOnClickListener(v -> {
            String nameParson = binding.editNamePerson.getText().toString().trim();
            String titelMassage = binding.editTitleMassage.getText().toString().trim();
            String massage = binding.editMassage.getText().toString().trim();
            if (nameParson.isEmpty()) {
                binding.editNamePerson.setError("أدخل من فضلك إسم المرسل");
            } else if (titelMassage.isEmpty()) {
                binding.editTitleMassage.setError("أدخل من فضلك عنوان الرسالة");
            } else if (massage.isEmpty()) {
                binding.editMassage.setError("أدخل من فضلك الرسالة");
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                customDialog = CustomdailogBinding.inflate(getLayoutInflater());
                builder.setView(customDialog.getRoot());
                customDialog.btnYes.setOnClickListener(v1 -> {
                    list.add(new ItemMassageStudentWithAdmin(nameParson,titelMassage,massage));
                    if (dBase.insertMassage(new ItemMassageStudentWithAdmin(nameParson,titelMassage,massage))) {
                        admin.notifyDataSetChanged();
                        dialog.dismiss();

                        startActivity(new Intent(context,SureSend.class));
                        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    }
                });
                customDialog.btnNo.setOnClickListener(v12 -> {
                    dialog.dismiss();
                });
                dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();
            }

        });
        binding.imageProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        Cursor cursor = dBase.getComment();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            binding.tvName.setText(nameProfile);
            binding.editNamePerson.setText(nameProfile);
        }
        binding.iconProfileScreen.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconEducation.setOnClickListener(v -> {
            startActivity(new Intent(context, HomePageScreen.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.icNot.setOnClickListener(v -> {
            startActivity(new Intent(context, Notices.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        binding.iconArrow.setOnClickListener(v -> {
            startActivity(new Intent(context,HomePageScreen.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });
        //massage
    }
}