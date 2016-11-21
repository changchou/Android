package com.jikexueyuan.alphaanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                AlphaAnimation animation = new AlphaAnimation(0,1);
//                animation.setDuration(1000);
//                v.startAnimation(animation);
//
//                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.anim));
            }
        });
    }
}
