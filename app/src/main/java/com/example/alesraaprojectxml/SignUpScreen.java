package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivitySginUpScreenBinding;

public class SignUpScreen extends AppCompatActivity {
    private ActivitySginUpScreenBinding binding;
    private Context context = SignUpScreen.this;
    private DBase dBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySginUpScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dBase = new DBase(context);
        binding.tvLogin.setOnClickListener(v -> {
            startActivity(new Intent(context, LoginScreen.class));
        });
        binding.btnSignUp.setOnClickListener(v -> {
            String userName = binding.editUserName.getText().toString().trim();
            String number = binding.editNumberOfUneversity.getText().toString().trim();
            String password = binding.editPassword.getText().toString().trim();
            String confirmPassword = binding.editConfirmPassword.getText().toString().trim();
            if (userName.isEmpty()) {
                binding.editUserName.setError("أدخل إسم المستخدم من فضلك");
            } else if (number.isEmpty()) {
                binding.editNumberOfUneversity.setError("أدخل الرقم الجامعي من فضلك");
            } else if (password.isEmpty()) {
                binding.editPassword.setError("أدخل كلمة المرور من فضلك");
            } else if (confirmPassword.isEmpty()) {
                binding.editConfirmPassword.setError("أدخل تاكيد كلمة المرور من فضلك");
            } else if (!confirmPassword.equals(password)) {
                binding.editConfirmPassword.setError("تاكد من تطابق كلمة المرور");
            } else {
                if (dBase.insertUser(new UserSignUpModel(userName, number, password))) {
                    startActivity(new Intent(context, LoginScreen.class));
                    Toast.makeText(context, "تم الحفظ بنجاح ", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}