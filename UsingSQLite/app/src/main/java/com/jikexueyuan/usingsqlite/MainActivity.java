package com.jikexueyuan.usingsqlite;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //传数据到listview
    private SimpleCursorAdapter adapter;
    //    private ListView list;
    private EditText etName, etSex;
    private Button btnAdd;
    private Db db;
    private SQLiteDatabase dbRead, dbWrite;

    private ListView lv;
    private View.OnClickListener btnAddListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues cv = new ContentValues();
            cv.put("name", etName.getText().toString());
            cv.put("sex", etSex.getText().toString());

            dbWrite.insert("user", null, cv);

            refreshListView();
            getitem();
        }
    };

    private AdapterView.OnItemLongClickListener listViewItemLongClickListener = new AdapterView.OnItemLongClickListener() {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("提醒").setMessage("您确定要删除吗？")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Cursor c = adapter.getCursor();
                            c.moveToPosition(position);
                            int itemId = c.getInt(c.getColumnIndex("_id"));
                            dbWrite.delete("user", "_id=?", new String[]{itemId + ""});
                            refreshListView();
                        }
                    })
                    .setNegativeButton("取消", null)
                    .show();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etSex = (EditText) findViewById(R.id.etSex);
        btnAdd = (Button) findViewById(R.id.btnAdd);
//        list = (ListView) findViewById(R.id.list);
        btnAdd.setOnClickListener(btnAddListener);
        lv = (ListView) findViewById(R.id.lv);

        db = new Db(this);
        //数据写入
//        SQLiteDatabase dbWrite = db.getWritableDatabase();
//
//        ContentValues cv = new ContentValues();
//        cv.put("name","小张");
//        cv.put("sex","男");
//        dbWrite.insert("user",null,cv);
//
//        cv = new ContentValues();
//        cv.put("name","小李");
//        cv.put("sex","女");
//        dbWrite.insert("user",null,cv);
//
//        dbWrite.close();

        //数据读取
//        SQLiteDatabase dbRead = db.getReadableDatabase();
//        Cursor c = dbRead.query("user", null, null, null, null, null, null);
//
//        while (c.moveToNext()) {
//            String name = c.getString(c.getColumnIndex("name"));
//            String sex = c.getString(c.getColumnIndex("sex"));
//            System.out.println(String.format("name = %s\nsex = %s",name,sex));
//        }

        //将内容传到ListView上
        dbRead = db.getReadableDatabase();
        dbWrite = db.getWritableDatabase();


        adapter = new SimpleCursorAdapter(this, R.layout.user_list_cell, null, new String[]{"name", "sex"}, new int[]{R.id.tvName, R.id.tvSex});
        lv.setAdapter(adapter);

        refreshListView();

        lv.setOnItemLongClickListener(listViewItemLongClickListener);

//        ArrayList<String> list = new ArrayList<>(getListView().getAdapter()),
//         System.out.println(getListView().getAdapter());
//        Intent i = new Intent(this,Main2Activity.class);
//        i.putStringArrayListExtra("list", (ArrayList<String>) getListView().getAdapter());
        getitem();
    }

    private void refreshListView() {
        Cursor c = dbRead.query("user", null, null, null, null, null, null);
        adapter.changeCursor(c);
    }

    private void getitem() {
        Cursor c = dbRead.query("user", null, null, null, null, null, null);
        while (c.moveToNext()) {
            String name = c.getString(c.getColumnIndex("name"));
            String sex = c.getString(c.getColumnIndex("sex"));
            System.out.println(String.format("name = %s\nsex = %s", name, sex));
            ArrayList<String> names = new ArrayList<>();
            names.add(name);
            Intent intent = new Intent(this, Main2Activity.class);
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("name", names);
            intent.putExtras(bundle);

        }
    }
}
