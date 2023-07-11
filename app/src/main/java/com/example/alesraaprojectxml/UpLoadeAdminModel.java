package com.example.alesraaprojectxml;

public class UpLoadeAdminModel {
    private int id;
    private String location;
    private String dis;
    private String path;

    public UpLoadeAdminModel(String location, String dis, String path) {
        this.location = location;
        this.dis = dis;
        this.path = path;
    }

    public UpLoadeAdminModel(String location, String dis) {
        this.location = location;
        this.dis = dis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
