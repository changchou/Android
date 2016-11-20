package com.jikexueyuan.learnrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rv = new RecyclerView(this);
        setContentView(rv);

//        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));//HORIZONTAL  水平  false 标准 ture  反转
        rv.setLayoutManager(new GridLayoutManager(this,3,LinearLayoutManager.HORIZONTAL,false));//表格布局   默认垂直方向

        rv.setAdapter(new MyAdapter());
    }

}
