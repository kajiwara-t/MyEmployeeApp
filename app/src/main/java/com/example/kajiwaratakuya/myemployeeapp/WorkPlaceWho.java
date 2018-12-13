package com.example.kajiwaratakuya.myemployeeapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.IOException;

public class WorkPlaceWho extends AppCompatActivity {
    private EmployeeDb employeeDb;
    private SQLiteDatabase db;
    private static final String TAG = "WorkPlaceWho";
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_place_who);
        Log.d(TAG, "onCreate通った");
        listView = (ListView) findViewById(R.id.work_place_who_ListView);

//        LinearLayout layout = new LinearLayout(this);
//        layout.setOrientation(LinearLayout.VERTICAL);
//        setContentView(layout);
//        setDatabase();

        Test_EmployeeDB test_employeeDB = new Test_EmployeeDB(this);
        SQLiteDatabase db = test_employeeDB.getReadableDatabase();
        //EmployeeDb employeeDb = new EmployeeDb(this);
        //SQLiteDatabase db = employeeDb.getReadableDatabase();

        Cursor c = db.query("employeeTable", new String[]{
                "_id", "name", "age", "birthPlace", "workPlace"}, "workPlace = ?", new String[]{"WHO"}, null, null, null);
//        boolean isEof = c.moveToFirst();
//        while (isEof) {
//            TextView textView = new TextView(this);
//            textView.setText(String.format("%d / %s / %d才 / %s / %s", c.getInt(0),
//                    c.getString(1), c.getInt(2),
//                    c.getString(3), c.getString(4)));
//            isEof = c.moveToNext();
//            layout.addView(textView);
//        }
//        c.close();
//        db.close();

        String[] from ={"_id","name","age","birthPlace","workPlace"};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,c,from,to,0);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListView listView2 = (ListView) adapterView;
                Cursor item = (Cursor) listView2.getItemAtPosition(i);
                String listName = item.getString(item.getColumnIndex("name"));
                int listId = item.getInt(item.getColumnIndex("_id"));
                int listAge = item.getInt(item.getColumnIndex("age"));
                String listBirthPlace = item.getString(item.getColumnIndex("birthPlace"));
                String listWorkPlace = item.getString(item.getColumnIndex("workPlace"));

                Intent intent = new Intent(WorkPlaceWho.this,TestListActivity.class);
                intent.putExtra("name",listName);
                intent.putExtra("_id",listId);
                intent.putExtra("age",listAge);
                intent.putExtra("birthPlace",listBirthPlace);
                intent.putExtra("workPlace",listWorkPlace);
                startActivity(intent);

            }

        });
    }

    private void setDatabase() {
        Log.d(TAG, "setDatabase通った");
        employeeDb = new EmployeeDb(this);
        try {
            employeeDb.createEmptyDataBase();
            db = employeeDb.getReadableDatabase();
        } catch (IOException ioe) {
            throw new Error("Unable to create database");
        } catch (SQLException sqle) {
            throw sqle;
        }
    }
}