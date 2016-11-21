package com.jikexueyuan.animateme;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnAnimateMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //属性动画
//                v.animate().rotation(360).setDuration(1000).start();
                //xml配置属性动画
//                ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animate_me);

                //xml属性集合
//                AnimatorSet animator = (AnimatorSet) AnimatorInflater.loadAnimator(MainActivity.this,R.animator.animate_me_set);
//                animator.setTarget(v);
//                animator.start();

                //java属性集合
//                ObjectAnimator.ofFloat(v,"rotation",0,90,90,360).setDuration(1000).start();关键帧
                AnimatorSet set = new AnimatorSet();
                set.setDuration(1000);
//                set.playSequentially(ObjectAnimator.ofFloat(v, "alpha", 0, 1), ObjectAnimator.ofFloat(v, "translationY", 0, 200));
                set.playSequentially(ObjectAnimator.ofFloat(v, "translationX", 0, 200),
                        ObjectAnimator.ofFloat(v, "translationY", 0, 200),
                        ObjectAnimator.ofFloat(v,"translationY",200,0),
                        ObjectAnimator.ofFloat(v,"translationX",200,0));
                set.start();

            }
        });

    }



}
