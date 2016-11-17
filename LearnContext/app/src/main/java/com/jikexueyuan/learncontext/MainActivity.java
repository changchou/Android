package com.jikexueyuan.learncontext;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    private TextView tv;

    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        tv = new TextView(this);
//                               tv.setText("Hello Wenny");
//        tv.setText(R.string.a);//R.string 是strings.xml的资源 我自己在里面写了<string name="a">Hello Wenny!</string>应该就是表示a代表后面的Hello Wenny！
//        setContentView(tv);

//        System.out.println(getResources().getText(R.string.a));

//        ImageView iv = new ImageView(this);
//        iv.setImageResource(R.mipmap.ic_launcher);
//        setContentView(iv);

        setContentView(R.layout.main1);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        textView.setText("共享的数据是：" + getApp().getTextData());
        findViewById(R.id.btnSaveData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((App) getApplicationContext()).setTextData(editText.getText().toString());
                textView.setText("共享的数据是：" + editText.getText().toString());
            }
        });
    }

    public App getApp() {
        return (App) getApplicationContext();
    }
}
