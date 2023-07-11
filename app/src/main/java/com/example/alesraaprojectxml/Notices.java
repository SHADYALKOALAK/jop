package com.example.alesraaprojectxml;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.alesraaprojectxml.databinding.ActivityNoticesBinding;

import java.util.ArrayList;

public class Notices extends AppCompatActivity implements AdapterNotices.ViewHandle {
    private ArrayList<ItemRecyclerNoticesScreen> arrayList;
    private Context context = Notices.this;
    //    private ArrayList<ItemRecyclerNoticesScreen> arrayList_2;
    private AdapterNotices.ViewHandle viewHandle;
    private DBase dBase;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNoticesBinding binding;
        binding = ActivityNoticesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dBase = new DBase(context);
        arrayList = new ArrayList<>();


        Cursor notifications = dBase.getNotifications();
        while (notifications.moveToNext()) {
            @SuppressLint("Range") String noty = notifications.getString(notifications.getColumnIndex(notifications.getColumnName(1)));
            arrayList.add(new ItemRecyclerNoticesScreen("", noty
                    , R.drawable.logo_2, "قبل 1 ثانية"));
        }

        AdapterNotices adapterNotices = new AdapterNotices(context, arrayList);
        binding.recycler.setAdapter(adapterNotices);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.recycler.setLayoutManager(linearLayoutManager);
//        binding.recycler2.setAdapter(adapterNotices);
//        LinearLayoutManager linearLayoutManager_2 = new LinearLayoutManager(context);
//        binding.recycler2.setLayoutManager(linearLayoutManager_2);
        binding.iconArrow.setOnClickListener(v -> {
            finish();
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
        binding.iconHomePage.setOnClickListener(v -> {
            Intent c = new Intent();
            c.setAction(Intent.ACTION_VIEW);
            c.setData(Uri.parse("https://student.israa.edu.ps/"));
            startActivity(c);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        });

        binding.iconOnlineLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, HomePageScreen.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        binding.tvClearAll.setOnClickListener(v -> {
            try {
                dBase.deleteTableData();
                arrayList.clear();
                adapterNotices.notifyDataSetChanged();
                Toast.makeText(context, "تم الحذف", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(context, "لم يتم الحذف", Toast.LENGTH_SHORT).show();
            }

        });
//        String delete=null;

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.START) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                if (dBase.deleteNotifications(idNoty())) {

                    arrayList.remove(position);
                    adapterNotices.notifyDataSetChanged();
                    Toast.makeText(context, "تم الحذف بنجاح", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "No", Toast.LENGTH_SHORT).show();
                }
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(binding.recycler);



    }

    @SuppressLint("Range")
    private int idNoty() {
        Cursor cursor = dBase.getNotifications();
        int id = 0;
        while (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex(cursor.getColumnName(0)));
        }
        return id;

    }



    @Override
    public void ClickHandle(boolean isChick, int pos) {
        Toast.makeText(context, pos + "", Toast.LENGTH_SHORT).show();
        arrayList.remove(pos);
    }

}
