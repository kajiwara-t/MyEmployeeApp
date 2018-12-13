package com.example.kajiwaratakuya.myemployeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TestListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_list);

        final Intent intent = getIntent();
        String setName = intent.getStringExtra("name");
        int setID = intent.getIntExtra("_id",0);
        int setAge = intent.getIntExtra("age",0);
        String setBirth = intent.getStringExtra("birthPlace");
        String setWork = intent.getStringExtra("workPlace");

        TextView nameText = findViewById(R.id.name);
        nameText.setText(setName);

        TextView idText = findViewById(R.id.id);
        idText.setText(String.valueOf(setID));

        TextView ageText = findViewById(R.id.age);
        ageText.setText(String.valueOf(setAge));

        TextView birthText = findViewById(R.id.birth);
        birthText.setText(setBirth);

        TextView workText = findViewById(R.id.work);
        workText.setText(setWork);

    }
}
