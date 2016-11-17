package com.jikexueyuan.sendargs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TheAty extends AppCompatActivity {

    private TextView tv;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_aty);
        editText = (EditText) findViewById(R.id.editText);
        final Intent i = getIntent();
//        //获取
////        Bundle data = i.getExtras();
//        //法二
//        Bundle data = i.getBundleExtra("data");
//
//        tv = (TextView) findViewById(R.id.tv);
//
////        tv.setText(i.getStringExtra("data"));
//        tv.setText(String.format("name=%s,age=%d,name1=%s",data.getString("name"),data.getInt("age"),data.getString("name1", "Lio")));//最后name1不存在，可以用data.getString（key，default），如果存在则为输出存在的值



        // 传递值对象
        tv = (TextView) findViewById(R.id.tv);
//        User user = (User) i.getSerializableExtra("user");
        User user = i.getParcelableExtra("user");
        tv.setText(String.format("User info(name=%s,age=%d)",user.getName(),user.getAge()));

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("data",editText.getText().toString());
                setResult(1, i);
                finish();
            }
        });
    }
}
