package com.jikexueyuan.sendargs;

import android.content.Intent;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);

        findViewById(R.id.btnStartAty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TheAty.class);
//                i.putExtra("data","Hello Wenny !");

//                //传递数据包
//                Bundle b = new Bundle();
//                b.putString("name","jikexueyuan");
//                b.putInt("age",2);
////                i.putExtras(b);
//                //法二（然并卵）
//                i.putExtra("data",b);


                //传递值对象
                i.putExtra("user", new User("jikexueyuan", 2));

//                startActivity(i);
                startActivityForResult(i, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        textView.setText("另一个Activity返回的数据是：" + data.getStringExtra("data"));
    }
}
