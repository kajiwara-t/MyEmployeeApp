package com.example.kajiwaratakuya.myemployeeapp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;

public class WorkPlaceTsukiji extends AppCompatActivity {

    private EmployeeDb employeeDb;
    private SQLiteDatabase db;
    private ListView listView;
    private static final String TAG = "WorkPlaceTsukiji";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_place_tsukiji);
        Log.d(TAG, "onCreate通った");

        listView = (ListView) findViewById(R.id.work_place_tsukiji_ListView);
//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        setContentView(layout);
//        setDatabase();


        EmployeeDb employeeDb = new EmployeeDb(this);
        SQLiteDatabase db = employeeDb.getReadableDatabase();

        Cursor c = db.query("employeeTable",new String[]{
                "_id","name","age","birthPlace","workPlace"},"workPlace = ?",new String[]{"築地"},null,null,null);
//        boolean isEof = c.moveToFirst();
//        while (isEof){
//            TextView textView = new TextView(this);
//            textView.setText(String.format("%d / %s / %d才 / %s / %s",c.getInt(0),
//                    c.getString(1),c.getInt(2),
//                    c.getString(3),c.getString(4)));
//            isEof = c.moveToNext();
//            layout.addView(textView);
//        }
//        c.close();
//        db.close();

        String[] from ={"_id","name","age","birthPlace","workPlace"};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,from,to,0);

        listView.setAdapter(adapter);
    }

    private void setDatabase() {
        employeeDb = new EmployeeDb(this);
        try {
            employeeDb.createEmptyDataBase();
            db = employeeDb.getReadableDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        } catch(SQLException sqle){
            throw sqle;
        }
    }
}