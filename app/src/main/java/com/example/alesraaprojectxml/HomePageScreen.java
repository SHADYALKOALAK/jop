package com.example.alesraaprojectxml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityHomePageScreenBinding;
import com.example.alesraaprojectxml.databinding.CustomdailogBinding;

import java.util.ArrayList;
import java.util.List;

public class HomePageScreen extends AppCompatActivity implements Rc_courses.Handle {
    private ActivityHomePageScreenBinding binding;
    private Context context = HomePageScreen.this;
    private List<CoursesModel> coursesModels;
    private Rc_courses rc_courses;
    private List<LectureModel> lectureModels;
    private RcLecture rcLecture;
    private Rc_courses.Handle handle;
    private DBase dBase;
    private AlertDialog alertDialog;
    private CustomdailogBinding customdailogBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomePageScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        coursesModels = new ArrayList<>();
        lectureModels = new ArrayList<>();
        dBase = new DBase(context);
        rcLecture = new RcLecture(context, lectureModels);
        rc_courses = new Rc_courses(context, coursesModels, handle);
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "هندسة البرمجيات", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "التجارة النقالة", "BMOB4313-s231"));
        coursesModels.add(new CoursesModel(R.drawable.img_3, "تصميم تجربة المستخدم", "BMOB4313-s231"));
        lectureModels.add(new LectureModel("تصميم تجربة المستخدم", "د. غسان أبو سمهدانة"));
        lectureModels.add(new LectureModel("هندسة البرمجيات", "م. ريهام مقاط"));
        lectureModels.add(new LectureModel("تصميم تجربة المستخدم", "د. غسان أبو سمهدانة"));
        lectureModels.add(new LectureModel("تصميم تجربة المستخدم", "د. غسان أبو سمهدانة"));
        binding.rcCourses.setAdapter(rc_courses);
        //
        binding.rcCourses.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, true));
        binding.rcLectureName.setAdapter(rcLecture);
        //
        Cursor cursor = dBase.getUser();
        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nameProfile = cursor.getString(cursor.getColumnIndex(DBase.COL_NAME));
            binding.tvName.setText(nameProfile);
        }
        binding.rcLectureName.setLayoutManager(new LinearLayoutManager(context, RecyclerView.VERTICAL, false));
        binding.icNot.setOnClickListener(v -> {
            startActivity(new Intent(context, Notices.class));
        });
        binding.iconMenu.setOnClickListener(v -> {
            startActivity(new Intent(context, RegisteredCourses.class));
        });
        binding.yo.setOnClickListener(v -> {
            Intent facebook = new Intent();
            facebook.setAction(Intent.ACTION_VIEW);
            facebook.setData(Uri.parse("https://www.youtube.com/watch?v=eLl-I9PwFyg"));
            startActivity(facebook);
        });
        binding.imageProfile.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);        });
        binding.iconHomework.setOnClickListener(v -> {
            startActivity(new Intent(context, HomeWorkDescription.class));
        });
        binding.iconModel.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://elearn.israa.edu.ps/"));
            startActivity(intent);
        });
        binding.iconProfileScreen.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);        });
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
                        SharedPreferences sharedPreferences=getSharedPreferences("login_save",MODE_PRIVATE);
                        SharedPreferences.Editor sh= sharedPreferences.edit();
                        sh.clear();
                        Toast.makeText(HomePageScreen.this, "تم تسجيل الخروج بنجاح", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(context,LoginScreen.class));
                        sh.apply();

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

    }



    @Override
    public void clickHandle(int position, String nameCourse, String idCourse) {
        startActivity(new Intent(getBaseContext(), e_Learning.class));


    }
}