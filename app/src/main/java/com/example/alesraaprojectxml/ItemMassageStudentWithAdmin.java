package com.example.alesraaprojectxml;

public class ItemMassageStudentWithAdmin {
    private String nameStudent;
    private String titleMassage;
    private String massage;

    public ItemMassageStudentWithAdmin(String nameStudent, String titleMassage, String massage) {
        this.nameStudent = nameStudent;
        this.titleMassage = titleMassage;
        this.massage = massage;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getTitleMassage() {
        return titleMassage;
    }

    public void setTitleMassage(String titleMassage) {
        this.titleMassage = titleMassage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
