package com.example.kajiwaratakuya.myemployeeapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

public class Test_EmployeeDB extends SQLiteOpenHelper {

    //データベース名
    private static final String DB_NAME = "test_employee.db";

    //データベースのバージョン指定
    private static final int DB_Version = 1;

    public static final String TESTEMPLOYEETABLE = "employeeTable";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_BIRTHPLACE = "birthPlace";
    public static final String COLUMN_WORKPLACE = "workPlace";

    public Test_EmployeeDB(Context context){
        super(context,DB_NAME,null,DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE employeeTable"
                +"("
                +"_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +"name text not null,"
                +"age text,"
                +"birthPlace text,"
                +"workPlace text"
        +")");
    }
    @Override
    public void onUpgrade (SQLiteDatabase db,int oldVersion, int newVersion) {
    }
}
