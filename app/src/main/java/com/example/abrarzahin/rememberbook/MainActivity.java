package com.example.abrarzahin.rememberbook;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase database= helper.getWritableDatabase();
    }



}
