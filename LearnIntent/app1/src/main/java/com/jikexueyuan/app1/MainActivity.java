package com.jikexueyuan.app1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartMyAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
//                    startActivity(new Intent("com.jikexueyuan.learnintent.intent.action.MyAty"));
                    startActivity(new Intent("com.jikexueyuan.learnintent.intent.action.MyAty", Uri.parse("app://hello")));
                    //加入过滤器选项之后 Uri.parse("app://hello")  指定Aty  app://任意字符

                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"无法启动",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
