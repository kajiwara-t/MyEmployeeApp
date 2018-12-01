package com.example.kajiwaratakuya.myemployeeapp;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.io.IOException;
import java.security.PrivateKey;

public class EmployeeList extends AppCompatActivity {

    private static final String TAG = "Hello";
    private EmployeeDb employeeDb;
    private SQLiteDatabase db;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate通った");
        setContentView(R.layout.activity_employee_list);

        listView = (ListView) findViewById(R.id.employeeListView);


        //10月1日レビュー時のもの。ListViewに変更
//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//
//
//        setContentView(layout);
//        setDatabase();

        EmployeeDb employeeDb = new EmployeeDb(this);
        SQLiteDatabase db = employeeDb.getReadableDatabase();

        Cursor c = db.query("employeeTable",new String[]{
                "_id","name","age","birthPlace","workPlace"},null,null,null,null,null);



        String[] from ={"_id","name","age","birthPlace","workPlace"};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,from,to,0);

        listView.setAdapter(adapter);




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
    }

    private void setDatabase() {

        Log.d(TAG, "setDatabase通った");

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