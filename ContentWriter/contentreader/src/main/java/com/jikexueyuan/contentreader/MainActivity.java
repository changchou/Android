package com.jikexueyuan.contentreader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uri URI = Uri.parse("content://com.jikexueyuan.cp");
        Cursor cursor = getContentResolver().query(URI, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String value = cursor.getString(cursor.getColumnIndex("name"));
                System.out.println(value + ">>>>>>>>>>>>>>>>>>>>");
            }

            cursor.close();
        }
    }
}
