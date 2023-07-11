package com.example.alesraaprojectxml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainWelcomeScreens extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout linearLayout;
    private TextView skip;
    private ViewPager pager;
    private Context context = MainWelcomeScreens.this;
    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wecome_screens);
        skip = findViewById(R.id.tv_skip);

        skip.setOnClickListener(v -> {
            Intent intent = new Intent(context, LoginScreen.class);
            startActivity(intent);
            finish();
        });


        ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setUpdateContriler(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };

        pager = (ViewPager) findViewById(R.id.viewPager);
        linearLayout = (LinearLayout) findViewById(R.id.layoutPager);
        viewPagerAdapter = new ViewPagerAdapter(context);
        pager.setAdapter(viewPagerAdapter);
        setUpdateContriler(0);
        pager.addOnPageChangeListener(changeListener);

    }

    public void setUpdateContriler(int pos) {
        dots = new TextView[4];
        linearLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(50);
            dots[i].setTextColor(getResources().getColor(R.color.grey, getApplication().getTheme()));
            linearLayout.addView(dots[i]);
        }
        dots[pos].setTextColor(getResources().getColor(R.color.blue, getApplication().getTheme()));

    }

    private int getItem(int item) {
        return pager.getCurrentItem() + item;
    }
}