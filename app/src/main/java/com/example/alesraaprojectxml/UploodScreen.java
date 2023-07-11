package com.example.alesraaprojectxml;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.autofill.CustomDescription;
import android.view.View;
import android.widget.Toast;

import com.example.alesraaprojectxml.databinding.ActivityUploodScreenBinding;
import com.example.alesraaprojectxml.databinding.CustomdailogBinding;

import java.util.ArrayList;
import java.util.List;

public class UploodScreen extends AppCompatActivity {
    private ActivityUploodScreenBinding binding;
    private Context context = UploodScreen.this;
    private DBase dBase;
    private ActivityResultLauncher<String> filePickerLauncher;
    private String filePath;
    private AdapterNotices adapterNotices;
    private ArrayList<ItemRecyclerNoticesScreen> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploodScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dBase = new DBase(context);
        list = new ArrayList<>();
        adapterNotices = new AdapterNotices(context, list);
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag", -1);

        switch (flag) {
            case 1:
                binding.editLink.setVisibility(View.GONE);
                binding.editMoreInfo.setVisibility(View.GONE);
                break;
            case 2:
                binding.editLink.setVisibility(View.VISIBLE);
                binding.editMoreInfo.setVisibility(View.GONE);
                binding.layoutFile.setVisibility(View.GONE);
                binding.editDescription.setVisibility(View.VISIBLE);
                binding.editTitle.setVisibility(View.VISIBLE);

                break;
            case 3:
                binding.editLink.setVisibility(View.GONE);
                binding.editMoreInfo.setVisibility(View.GONE);
                binding.layoutFile.setVisibility(View.GONE);
                break;
            case 4:
                binding.editMoreInfo.setVisibility(View.GONE);
                binding.layoutFile.setVisibility(View.GONE);
                binding.editLink.setVisibility(View.GONE);
                break;
            case 5:
                binding.editLink.setVisibility(View.VISIBLE);
                binding.layoutFile.setVisibility(View.GONE);
                binding.editDescription.setVisibility(View.VISIBLE);
                binding.editTitle.setVisibility(View.VISIBLE);
                binding.editMoreInfo.setVisibility(View.GONE);
                break;
        }


        binding.btnUpLoade.setOnClickListener(v -> {
            String location = binding.editTitle.getText().toString().trim();
            String dis = binding.editDescription.getText().toString().trim();
            String link = binding.editLink.getText().toString().trim();
            switch (flag) {
                case 1:
                    if (!location.isEmpty() && !dis.isEmpty() && !filePath.isEmpty()) {
                        if (dBase.insertAdminFile(new UpLoadeAdminModel(location, dis, filePath))) {
                            dBase.insertNotifications("تم رفع مهمة جديدة");
                            Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                case 2:
                    if (!location.isEmpty() && !dis.isEmpty() && !link.isEmpty()) {
                        if (dBase.insertExam(new UpLoadeAdminModel(location, dis, link))) {
                            dBase.insertNotifications("تم رفع مهمة جديدة");
                            Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
                            finish();
                        }

                    }
                case 3:
                    if (!location.isEmpty() && !dis.isEmpty()) {
                        if (dBase.insertAdminDis(new UpLoadeAdminModel(location, dis))) {
                            dBase.insertNotifications("تم رفع مهمة جديدة");
                            Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                case 4:
                    if (!location.isEmpty() && !dis.isEmpty()) {
                        if (dBase.insertAdminDis(new UpLoadeAdminModel(location, dis))) {
                            dBase.insertNotifications("تم رفع مهمة جديدة");
                            Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                case 5:
                    if (!location.isEmpty() && !dis.isEmpty() && !link.isEmpty()) {
                        if (dBase.insertViedo(new UpLoadeAdminModel(location, dis, link))) {
                            dBase.insertNotifications("تم رفع فيديو مصور");
                            Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

            }
        });

        filePickerLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        // Handle the selected file here
                        filePath = uri.getPath();
                        // Upload the file to your application or perform further operations
                        Toast.makeText(context, "Selected file: " + filePath, Toast.LENGTH_SHORT).show();
                        binding.btnChooseFile.setVisibility(View.VISIBLE);
                        binding.edUpLoadeFile.setText("تم رفع الملف");
                    }
                });
        binding.btnChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch file picker when a button or any UI element is clicked
                openFilePicker();


            }
        });
        binding.iconArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });


    }

    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        filePickerLauncher.launch("application/pdf");
    }


//    private void showAlertDialog(String location, String dis, String path) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        customDialog = CustomdailogBinding.inflate(getLayoutInflater());
//        builder.setView(customDialog.getRoot());
//        customDialog.tvMassage.setText("هل أنت متأكد من عملية الرفع");
//        customDialog.tvDis.setText("تأكيد الرفع");
//        customDialog.btnYes.setOnClickListener(v1 -> {
//            if (dBase.insertAdminFile(new UpLoadeAdminModel(location, dis, path))) {
//                Toast.makeText(context, "تم الرفع", Toast.LENGTH_SHORT).show();
//                finish();
//            }
//        });
//        customDialog.btnNo.setOnClickListener(v12 -> {
//            dialog.dismiss();
//        });
//        dialog = builder.create();
//        dialog.show();
//    }

}
