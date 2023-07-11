package com.example.alesraaprojectxml;

public class ItemRvHomeWorkExport {
    private String name;
    private String nameCourse;

    public ItemRvHomeWorkExport(String name, String nameCourse) {
        this.name = name;
        this.nameCourse = nameCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }
}