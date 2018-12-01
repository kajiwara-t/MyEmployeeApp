package com.example.kajiwaratakuya.myemployeeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class EmployeeMainAvtity extends AppCompatActivity implements View.OnClickListener{

    private Button employeeList_button;
    private Button workPlaceOffice_button;
    private Button workPlaceWho_button;
    private Button workplaceTsukiji_button;
    private Button edit_button;
    private static final String TAG = "EmployeeMainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_main_avtity);
        Log.d(TAG, "onCreate通った");
        employeeList_button = (Button) findViewById(R.id.employeeList_button);
        workPlaceOffice_button = (Button) findViewById(R.id.workplaceOffice_button);
        workPlaceWho_button = (Button) findViewById(R.id.workplaceWho_button);
        workplaceTsukiji_button = (Button) findViewById(R.id.workPlaceTsukiji_button);
        edit_button = (Button) findViewById(R.id.edit_button);

        employeeList_button.setOnClickListener(this);
        workPlaceOffice_button.setOnClickListener(this);
        workPlaceWho_button.setOnClickListener(this);
        workplaceTsukiji_button.setOnClickListener(this);
        edit_button.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){

            case R.id.employeeList_button:
                Intent employeeList = new Intent(getApplication(),EmployeeList.class);
                startActivity(employeeList);
                break;
            case R.id.workplaceOffice_button:
                Intent workplaceOffice = new Intent(getApplication(),WorkPlaceOffice.class);
                startActivity(workplaceOffice);
                break;
            case R.id.workplaceWho_button:
                Intent workplaceWho = new Intent(getApplication(),WorkPlaceWho.class);
                startActivity(workplaceWho);
                break;
            case R.id.workPlaceTsukiji_button:
                Intent workplaceTsukiji = new Intent(getApplication(),WorkPlaceTsukiji.class);
                startActivity(workplaceTsukiji);
                break;
            case R.id.edit_button:
                Intent edit_activity = new Intent(getApplication(),Edit_activity.class);
                startActivity(edit_activity);
        }
    }
}

