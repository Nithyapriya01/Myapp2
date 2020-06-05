package com.example.app2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    private Button Btn1,Btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Btn1 = findViewById(R.id.btnAdd);
        Btn2 = findViewById(R.id.btnView);
        viewAll();

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

      public void openActivity2(){
          Intent intent = new Intent(this, Activity2.class);
          startActivity(intent);
      }
      public void viewAll(){
        Btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Cursor res = myDb.getAllData();
                           if (res.getCount() == 0){
                           showMessage("Error","No data found");
                           return;
                       }
                       StringBuffer buffer = new StringBuffer();
                       while (res.moveToNext()){
                           buffer.append("Name :"+res.getString(0)+"\n");
                           buffer.append("Age :"+res.getString(1)+"\n\n");
                       }
                       showMessage("Data",buffer.toString());

                    }
                }
        );
      }
      public void showMessage(String Title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.show();
      }

}
