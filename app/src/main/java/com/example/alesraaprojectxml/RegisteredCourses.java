package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

import com.example.alesraaprojectxml.databinding.ActivityRegisteredCoursesBinding;

import java.util.ArrayList;
import java.util.List;

public class RegisteredCourses extends AppCompatActivity implements Rc_courses.Handle {
    private ActivityRegisteredCoursesBinding binding;
    private Context context = RegisteredCourses.this;
    private Rc_courses rc_courses;
    private List<CoursesModel> coursesModels;
    private Rc_courses.Handle handle;
    private DBase dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisteredCoursesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        coursesModels = new ArrayList<>();
        dBase = new DBase(context);
        rc_courses = new Rc_courses(context, coursesModels, handle);
        rc_courses = new Rc_courses(context, coursesModels, handle);
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "هندسة البرمجيات", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "التجارة النقالة", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "هندسة البرمجيات", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "التجارة النقالة", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "هندسة البرمجيات", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "التجارة النقالة", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        binding.rcRegisteredCourses.setAdapter(rc_courses);
        binding.rcRegisteredCourses.setLayoutManager(new GridLayoutManager(context, 2));
        Cursor cursor = dBase.getUser();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(DBase.COL_NAME));
            binding.tvName.setText(nameProfile);
        }
        binding.iconArrow.setOnClickListener(v -> {
            finish();
        });
        binding.icNot.setOnClickListener(v -> {
            startActivity(new Intent(context, Notices.class));
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
            startActivity(c);        });
        binding.iconEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomePageScreen.class));
            }
        });
        binding.imageProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent c = new Intent();
                c.setAction(Intent.ACTION_VIEW);
                c.setData(Uri.parse("https://student.israa.edu.ps/"));
                startActivity(c);
            }
        });
    }


    @Override
    public void clickHandle(int position, String nameCourse, String idCourse) {
        startActivity(new Intent(getBaseContext(), e_Learning.class));

    }
}