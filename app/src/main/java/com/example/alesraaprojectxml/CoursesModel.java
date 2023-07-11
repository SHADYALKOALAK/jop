package com.example.alesraaprojectxml;

public class   CoursesModel {
    private int image;
    private String nameCourses;
    private String idCourses;


    public CoursesModel(int image, String nameCourses, String idCourses) {
        this.image = image;
        this.nameCourses = nameCourses;
        this.idCourses = idCourses;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNameCourses() {
        return nameCourses;
    }

    public void setNameCourses(String nameCourses) {
        this.nameCourses = nameCourses;
    }

    public String getIdCourses() {
        return idCourses;
    }

    public void setIdCourses(String idCourses) {
        this.idCourses = idCourses;
    }
}
