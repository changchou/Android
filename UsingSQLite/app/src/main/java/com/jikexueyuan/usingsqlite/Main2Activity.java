package com.jikexueyuan.usingsqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        Bundle b = i.getExtras();
//       ArrayList<String> list =  i.getStringArrayListExtra("list");
        List<String> list = b.getStringArrayList("name");
        String[] l = list.toArray(new String[list.size()]);
        for (int j = 0;j<l.length;j++){
            System.out.println(l[j]);
        }
//       Db db = new Db(this);
//        SQLiteDatabase dbRead = db.getReadableDatabase();
//        Cursor c = dbRead.query("user", null, null, null, null, null, null);
//        while (c.moveToNext()) {
//            String name = c.getString(c.getColumnIndex("name"));
//            String sex = c.getString(c.getColumnIndex("sex"));
//            System.out.println(String.format("name = %s\nsex = %s",name,sex));
//        }

        }
}
