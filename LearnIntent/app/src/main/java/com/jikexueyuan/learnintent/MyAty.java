package com.jikexueyuan.learnintent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2015/11/17 0017.
 */
public class MyAty extends AppCompatActivity {

    public static final String ACTION = "com.jikexueyuan.learnintent.intent.action.MyAty";//必须是 <action android:name

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myaty);
    }
}
