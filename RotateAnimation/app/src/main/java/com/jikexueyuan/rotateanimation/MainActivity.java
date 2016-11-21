package com.jikexueyuan.rotateanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnRotaeAnim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                RotateAnimation animation = new RotateAnimation(0,360);
//                RotateAnimation animation = new RotateAnimation(0,360,100,50);
                RotateAnimation animation = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(1000);
                v.startAnimation(animation);

                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.ra));
            }
        });
    }
}
