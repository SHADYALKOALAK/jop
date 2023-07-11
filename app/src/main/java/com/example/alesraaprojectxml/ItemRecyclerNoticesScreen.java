package com.example.alesraaprojectxml;

public class ItemRecyclerNoticesScreen {
   private String nameCourse;
   private String description;
   private int image;
   private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public ItemRecyclerNoticesScreen(String nameCourse, String description, int image, String date) {
        this.nameCourse = nameCourse;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
