package com.example.abrarzahin.rememberbook;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertNote("New note");

        Cursor cursor= getContentResolver().query(NotesProvider.CONTENT_URI,
                DBOpenHelper.ALL_COLUMNS,null,null,null,null);
        String [] from= {DBOpenHelper.NOTE_TEXT};
        int [] to= {android.R.id.text1};
        CursorAdapter cursorAdapter= new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,cursor,from,to,0);
        ListView list= (ListView) findViewById(android.R.id.list);
        list.setAdapter(cursorAdapter);


    }

    private void insertNote(String noteText) {
        ContentValues values= new ContentValues();
        values.put(DBOpenHelper.NOTE_TEXT,noteText);
        Uri noteUri= getContentResolver().insert(NotesProvider.CONTENT_URI,values);
        Log.d("MainActivity","Inserted note" + noteUri.getLastPathSegment());
    }


}
