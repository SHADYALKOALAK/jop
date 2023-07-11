package com.example.alesraaprojectxml;

public class LectureModel {
    private String nameCourses;
    private String name;


    public LectureModel(String nameCourses, String name) {
        this.nameCourses = nameCourses;
        this.name = name;
    }

    public String getNameCourses() {
        return nameCourses;
    }

    public void setNameCourses(String nameCourses) {
        this.nameCourses = nameCourses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
