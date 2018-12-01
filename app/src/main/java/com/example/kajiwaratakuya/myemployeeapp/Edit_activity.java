package com.example.kajiwaratakuya.myemployeeapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Edit_activity extends AppCompatActivity {

    private static EditText add_id;
    private static EditText addName;
    private static EditText addAge;
    private static EditText AddBirthPlace;
    private static EditText AddWorkPlace;
    Button addBtn;
    Button updateBtn;
    Button deleteBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_activity);

        add_id = (EditText)findViewById(R.id.id_text);
        addName = (EditText)findViewById(R.id.name_text);
        addAge = (EditText)findViewById(R.id.age_text);
        AddBirthPlace = (EditText)findViewById(R.id.place_text);
        AddWorkPlace = (EditText)findViewById(R.id.work_place_text);
        addBtn = (Button)findViewById(R.id.add_button);
        updateBtn = (Button)findViewById(R.id.update_button);
        deleteBtn = (Button)findViewById(R.id.delete_button);


        EmployeeDb employeeDb = new EmployeeDb(this);
        final SQLiteDatabase db = employeeDb.getReadableDatabase();

        //データベースへ追加

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id",add_id.getText().toString());
                contentValues.put("name",addName.getText().toString());
                contentValues.put("age",addAge.getText().toString());
                contentValues.put("birthplace",AddBirthPlace.getText().toString());
                contentValues.put("workPlace",AddWorkPlace.getText().toString());
                db.insert("employeeTable",null,contentValues);
            }
        });

        //データベース更新

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _id = add_id.getText().toString();
                String name = addName.getText().toString();
            }
        });

        //データベース削除
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteName = addName.getText().toString();
                ContentValues contentValues = new ContentValues();
                contentValues.put("name",addName.getText().toString());
                db.delete("employeeTable","name=?",new String[]{deleteName});
            }
        });


    }
}
