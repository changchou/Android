package com.jikexueyuan.scaleanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//

        findViewById(R.id.btnScaleAnim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//              ScaleAnimation  animation = new ScaleAnimation(0,1,0,1);
//              ScaleAnimation animation = new ScaleAnimation(0,1,0,1,100,50);
                ScaleAnimation animation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(1000);
//                v.startAnimation(animation);


                v.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.sa));

            }
        });
    }
}
