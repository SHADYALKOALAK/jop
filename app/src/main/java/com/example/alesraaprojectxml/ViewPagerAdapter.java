package com.example.alesraaprojectxml;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    int titel[] = {R.string.Access_to_Learning, R.string.Smooth_navigation, R.string.Notifications, R.string.EasyLogin,};
    int image[] = {R.drawable.welcome_screen1, R.drawable.welcome_screen2, R.drawable.welcome_screen3, R.drawable.welcome_screen4,};
    int subtitle[] = {
            R.string.tv_welcome1,
            R.string.tv_welcome2,
            R.string.tv_welcome3,
            R.string.tv_welcome4,
    };

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return titel.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.welcome_screen1, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView skip = (TextView) view.findViewById(R.id.tv_skip);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageW = (ImageView) view.findViewById(R.id.image_welcome);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView text = (TextView) view.findViewById(R.id.tv_welcome);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView supText = (TextView) view.findViewById(R.id.tv_textWelcome);
        imageW.setImageResource(image[position]);
        text.setText(titel[position]);
        supText.setText(subtitle[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout) object);
    }
}
