package com.example.alesraaprojectxml;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "E_learning_DataBse";
    public static final String Table_NAMEUSRT = "user_data";
    public static final String COL_ID = "idComment";
    public static final String COL_ID_USER = "idUser";
    public static final String COL_NAME = "user_name";
    public static final String COL_NUMBER = "numberUser";
    public static final String COL_PASSWORD = "user_password";
    public static final int DB_VERSION = 23;
    public static final String TN_COMMENT = "comment";
    public static final String COL_COMMENT = "massage";
    public static final String TN_MASSAGE = "massageToAdmin";
    public static final String COL_MASSAGE = "colMassage";
    public static final String COL_NAME_PERSONAL = "namePerson";
    public static final String COL_TITlE_MASSAGE = "titleMassage";


    //DATA

    public DBase(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TN_COMMENT + "(idComment INTEGER Primary key AUTOINCREMENT,massage TEXT,name TEXT)");
        db.execSQL("CREATE TABLE " + Table_NAMEUSRT + " ( " + COL_ID_USER + " INTEGER Primary key AUTOINCREMENT , "
                + COL_NAME + " TEXT , "
                + COL_NUMBER + " TEXT , "
                + COL_PASSWORD + " TEXT) ");
        db.execSQL("CREATE TABLE " + TN_MASSAGE + " ( " + COL_MASSAGE + " TEXT , "
                + COL_NAME_PERSONAL + " TEXT , "
                + COL_TITlE_MASSAGE + " TEXT)");
        db.execSQL("CREATE TABLE FilePath (id INTEGER Primary key AUTOINCREMENT,path TEXT)");
        db.execSQL("CREATE TABLE UpLoadeAdmin (id INTEGER Primary key AUTOINCREMENT,locationAdmin TEXT,disAdmin TEXT ,pathAdmin TEXT)");
        db.execSQL("CREATE TABLE UpLoadeToDis (id INTEGER Primary key AUTOINCREMENT,locationDis TEXT,disDis TEXT)");
        db.execSQL("CREATE TABLE UpLoadeExam (id INTEGER Primary key AUTOINCREMENT,location TEXT,dis TEXT ,path TEXT)");
        db.execSQL("CREATE TABLE Noty (id INTEGER Primary key AUTOINCREMENT,notyfcations TEXT)");
        db.execSQL("CREATE TABLE CommentAdmin (id INTEGER Primary key AUTOINCREMENT,commentAdmin TEXT)");
        db.execSQL("CREATE TABLE MarkAdmin (id INTEGER Primary key AUTOINCREMENT,mark TEXT,name TEXT)");
        db.execSQL("CREATE TABLE ViedoAdmin (id INTEGER Primary key AUTOINCREMENT,pathVideo TEXT,title TEXT,disViedo TEXT)");
        //
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TN_COMMENT);
        db.execSQL("DROP TABLE IF EXISTS " + Table_NAMEUSRT);
        db.execSQL("DROP TABLE IF EXISTS " + TN_MASSAGE);
        db.execSQL("DROP TABLE IF EXISTS FilePath");
        db.execSQL("DROP TABLE IF EXISTS UpLoadeAdmin");
        db.execSQL("DROP TABLE IF EXISTS UpLoadeToDis");
        db.execSQL("DROP TABLE IF EXISTS UpLoadeExam");
        db.execSQL("DROP TABLE IF EXISTS CommentAdmin");
        db.execSQL("DROP TABLE IF EXISTS MarkAdmin");
        db.execSQL("DROP TABLE IF EXISTS ViedoAdmin");
        onCreate(db);

    }

    public boolean insertComment(CommentsModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("massage", model.getComment());
        values.put("name", model.getName());
        long re = database.insert(TN_COMMENT, null, values);
        return re != -1;
        //
    }

    public Cursor getComment() {
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("Select * From " + TN_COMMENT, null);
        return cursor;
        //
    }

    public boolean insertUser(UserSignUpModel user) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NAME, user.getUserName());
        contentValues.put(COL_PASSWORD, user.getPassword());
        contentValues.put(COL_NUMBER, user.getNumber());
        long re = sqLiteDatabase.insert(Table_NAMEUSRT, null, contentValues);
        return re != -1;
    }

    public Cursor getUser() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From " + Table_NAMEUSRT, null);
        return cursor;
    }

    public boolean insertMassage(ItemMassageStudentWithAdmin massage) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_MASSAGE, massage.getMassage());
        values.put(COL_NAME_PERSONAL, massage.getNameStudent());
        values.put(COL_TITlE_MASSAGE, massage.getTitleMassage());
        long re = database.insert(TN_MASSAGE, null, values);
        return re != -1;

    }

    public Cursor getMassage() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From " + TN_MASSAGE, null);
        return cursor;

    }

    public boolean insertPathFile(String path) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("path", path);
        long re = database.insert("FilePath", null, values);
        return re != -1;

    }

    public Cursor getPathFile() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From FilePath", null);
        return cursor;
    }

    public boolean insertAdminFile(UpLoadeAdminModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("locationAdmin", model.getLocation());
        values.put("disAdmin", model.getDis());
        values.put("pathAdmin", model.getPath());
        long re = database.insert("UpLoadeAdmin", null, values);
        return re != -1;

    }

    public Cursor getAdminFile() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From UpLoadeAdmin", null);
        return cursor;

    }

    public boolean insertAdminDis(UpLoadeAdminModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("locationDis", model.getLocation());
        values.put("disDis", model.getDis());
        long re = database.insert("UpLoadeToDis", null, values);
        return re != -1;

    }

    public Cursor getAdminDis() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From UpLoadeToDis", null);
        return cursor;

    }

    public boolean insertExam(UpLoadeAdminModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("location", model.getLocation());
        values.put("dis", model.getDis());
        values.put("path", model.getPath());
        long re = database.insert("UpLoadeExam", null, values);
        return re != -1;

    }

    public Cursor getExam() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From UpLoadeExam", null);
        return cursor;

    }

    public boolean insertNotifications(String notifications) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("notyfcations", notifications);
        long re = database.insert("Noty", null, values);
        return re != -1;

    }

    public Cursor getNotifications() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From Noty", null);
        return cursor;

    }

    public boolean insertCommentAdmin(String commentAdmin) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("commentAdmin", commentAdmin);
        long re = database.insert("CommentAdmin", null, values);
        return re != -1;

    }

    public Cursor getCommentAdmin() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From CommentAdmin", null);
        return cursor;

    }

    public boolean insertMarkAdmin(String mark, String name) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mark", mark);
        values.put("name", name);
        long re = database.insert("MarkAdmin", null, values);
        return re != -1;
    }

    public Cursor getMarkAdmin() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From MarkAdmin", null);
        return cursor;

    }

    public boolean insertViedo(UpLoadeAdminModel model) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("pathVideo", model.getPath());
        values.put("title", model.getLocation());
        values.put("disViedo", model.getDis());
        long re = database.insert("ViedoAdmin", null, values);
        return re != -1;

    }

    public Cursor getViedon() {
        SQLiteDatabase dp = this.getReadableDatabase();
        Cursor cursor = dp.rawQuery("Select * From ViedoAdmin", null);
        return cursor;

    }


}
