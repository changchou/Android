package com.jikexueyuan.listviewexample.controllers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.Student;

public class CustomListActivity extends AppCompatActivity {

    private ListView listView;
    private CustomListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        listView = (ListView) findViewById(R.id.listView);

        adapter = new CustomListAdapter(this);

        listView.setAdapter(adapter);

        adapter.add(new Student("赵六",21));
        adapter.add(new Student("孙七",22));
        adapter.add(new Student("周八",23));
    }
}
