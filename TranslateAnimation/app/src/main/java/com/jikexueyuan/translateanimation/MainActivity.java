package com.jikexueyuan.translateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.btntranslateAnim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAnimation animation = new TranslateAnimation(0, 200, 0, 200);
                animation.setDuration(1000);
                v.startAnimation(animation);



                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.ta));
            }
        });
    }
}
