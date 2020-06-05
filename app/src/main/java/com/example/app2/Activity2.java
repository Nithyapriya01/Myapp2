package com.example.app2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    EditText editname,editage;
    Button save;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        myDb = new DatabaseHelper(this);
        editname = (EditText) findViewById(R.id.etname);
        editage = (EditText) findViewById(R.id.etage);
        save = (Button) findViewById(R.id.save);
        AddData();


    }

    public void AddData(){
        save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       boolean isInserted = myDb.insertData(editname.getText().toString(),editage.getText().toString());
                       if (isInserted = true)
                           Toast.makeText(Activity2.this,"Saved",Toast.LENGTH_SHORT).show();
                       else
                           Toast.makeText(Activity2.this,"Not Saved",Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

        }


