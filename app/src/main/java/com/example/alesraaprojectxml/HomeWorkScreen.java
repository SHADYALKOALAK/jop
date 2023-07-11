package com.example.alesraaprojectxml;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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

import com.example.alesraaprojectxml.databinding.ActivityHomeWorkScreenBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeWorkScreen extends AppCompatActivity {
    private ActivityHomeWorkScreenBinding binding;
    private Context context = HomeWorkScreen.this;
    private List<CommentsModel> commentsModels;
    private Rc_Comment rc_comment;
    private DBase dataBase;
    private String filePath;
    private String name;
    private ActivityResultLauncher<String> filePickerLauncher;


    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeWorkScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        commentsModels = new ArrayList<>();
        rc_comment = new Rc_Comment(context, commentsModels);
        dataBase = new DBase(context);


        Cursor cursor = dataBase.getComment();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String comment = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(1)));
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(cursor.getColumnName(2)));
            commentsModels.add(new CommentsModel(nameProfile, comment));
            binding.tvName.setText(nameProfile);
        }


        Cursor marks = dataBase.getMarkAdmin();
        while (marks.moveToNext()) {
            String mark = marks.getString(marks.getColumnIndex(marks.getColumnName(1)));
            binding.tvMark.setText("الدرجة :" + mark);

        }

        Cursor file = dataBase.getAdminFile();
        while (file.moveToNext()) {
            String location = file.getString(file.getColumnIndex(file.getColumnName(1)));
            String dis = file.getString(file.getColumnIndex(file.getColumnName(2)));
            String path = file.getString(file.getColumnIndex(file.getColumnName(3)));
            binding.tvTitle.setText(location);
            binding.tvText.setText(dis);
            binding.tvPath.setText(path);
            binding.iconFile.setVisibility(View.VISIBLE);
        }

        binding.rcComments.setAdapter(rc_comment);
        binding.rcComments.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));

        binding.iconArrow.setOnClickListener(v -> {
            finish();
        });
        binding.icNot.setOnClickListener(v -> {
            startActivity(new Intent(context, Notices.class));
        });
        binding.imageProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
        });
        binding.iconProfileScreen.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
        });
        binding.iconEducation.setOnClickListener(v -> {
            startActivity(new Intent(context, HomePageScreen.class));
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(intent);
        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
        });

        binding.btnSend.setOnClickListener(v -> {
            int vi = binding.iconFile.getVisibility();
            if (vi != 0) {
                Toast.makeText(context, "يجب عليك اختار الملف أولا", Toast.LENGTH_SHORT).show();
            } else {
                if (dataBase.insertPathFile(filePath)) {
                    Toast.makeText(context, "تم حفظ الملف", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Cursor user = dataBase.getUser();
        while (user.moveToNext()) {
            name = user.getString(user.getColumnIndex(DBase.COL_NAME));
        }
        binding.btnSend1.setOnClickListener(v -> {
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
        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        // Handle the selected file here
                        filePath = uri.getPath();
                        // Upload the file to your application or perform further operations
                        Toast.makeText(context, "Selected file: " + filePath, Toast.LENGTH_SHORT).show();
                        binding.iconFile.setVisibility(View.VISIBLE);
                    }
                });
        binding.chooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch file picker when a button or any UI element is clicked
                openFilePicker();


            }
        });

        binding.iconFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int visibility = binding.iconFile.getVisibility();
                if (visibility == 0) {
                    startActivity(new Intent(context, FileScreen.class));

                }
            }
        });


    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        filePickerLauncher.launch("application/pdf");
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_PICK_FILE && resultCode == RESULT_OK) {
//            if (data != null) {
//                Uri fileUri = data.getData();
//                if (fileUri != null) {
//                    // Handle the selected file here
//                    String filePath = fileUri.getPath();
//                    // Upload the file to your application or perform further operations
//                    Toast.makeText(this, "Selected file: " + filePath, Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}