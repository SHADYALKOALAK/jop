package com.example.alesraaprojectxml;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.alesraaprojectxml.databinding.ActivityLoginScreenBinding;
import com.google.firebase.auth.FirebaseAuth;

public class LoginScreen extends AppCompatActivity {
    private ActivityLoginScreenBinding binding;
    private Context context = LoginScreen.this;
    private DBase dBase;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        FirebaseAuth auth = FirebaseAuth.getInstance();
        binding.checkbox.setChecked(false);
        sharedPreferences = getSharedPreferences("login_save", MODE_PRIVATE);
        boolean isTrue = sharedPreferences.getBoolean("x", false);
        if (isTrue) {
            startActivity(new Intent(context, HomePageScreen.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }


        dBase = new DBase(context);
        // loginToHomePage
        binding.btnLogin.setOnClickListener(v -> {
            String number = binding.editNumberOfUneversity.getText().toString().trim();
            String password = binding.editPassword.getText().toString().trim();

            if (number.isEmpty()) {
                binding.editNumberOfUneversity.setError("من فضلك أدخل رقم الجامعي");
            } else if (password.isEmpty()) {
                binding.editPassword.setError("من فضلك أدخل كلمة المرور");
            } else {
                auth.signInWithEmailAndPassword(number, password).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(context, HomeWorkScreen.class));
                        binding.progressCircular.setVisibility(View.VISIBLE);
                        binding.progressCircular.setProgress(2);
                        finish();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("خطأ في التسجيل ").setMessage("عذراً هذا الحساب غير متوفر! *الرجاء تسجيل حساب جديد*");
                        builder.show();
                    }
                });
            }
        });
        binding.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                sharedPreferences = getSharedPreferences("login_save", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("x", isChecked);
                editor.apply();


            }
        });
        binding.tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, SignUpScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


    }

//    @SuppressLint("Range")
//    private boolean chickLogin(String number, String password) {
//        if (number.equals("123") && password.equals("Admin")) {
//            startActivity(new Intent(context, Admin_1.class));
//            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//            return true;
//        }
//        Cursor cursor = dBase.getUser();
//        while (cursor.moveToNext()) {
//            if (number.equals(cursor.getString(cursor.getColumnIndex(DBase.COL_NUMBER))) && password.equals(cursor.getString(cursor.getColumnIndex(DBase.COL_PASSWORD)))) {
//                startActivity(new Intent(context, HomePageScreen.class));
//                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
//                return true;
//            }
//        }
//        return false;
//    }
}