package com.jikexueyuan.contentwriter;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                write();
            }
        });
    }

    public void write(){
        ContentValues values = new ContentValues();

        values.put("name","Java");
        getContentResolver().insert(Myprovider.URI,values);

        values.put("name","Swift");
        getContentResolver().insert(Myprovider.URI,values);

        values.put("name","Python");
        getContentResolver().insert(Myprovider.URI,values);

        values.put("name","C#");
        getContentResolver().insert(Myprovider.URI,values);
    }
}
