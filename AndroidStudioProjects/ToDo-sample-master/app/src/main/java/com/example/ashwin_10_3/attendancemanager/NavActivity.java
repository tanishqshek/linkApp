package com.example.ashwin_10_3.attendancemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class NavActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);


    }

    public void MainActivity(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void AttActivity(View view) {
        Intent intent = new Intent(this,AttActivity.class);
        startActivity(intent);
    }

    public void LibActivity(View view) {
        Intent intent = new Intent(this,LibActivity.class);
        startActivity(intent);
    }

    public void ImpDocs(View view) {
        Intent intent = new Intent(this,ImpDocs.class);
        startActivity(intent);
    }
}
