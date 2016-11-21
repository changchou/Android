package com.jikexueyuan.layoutanimationinlinerlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout view = (LinearLayout) View.inflate(this, R.layout.activity_main, null);
        setContentView(view);

        ScaleAnimation sa = new ScaleAnimation(0,1,0,1);
        sa.setDuration(2000);

        LayoutAnimationController lac = new LayoutAnimationController(sa,0.5f);//0.5f 延迟  一个一个出来
        lac.setOrder(LayoutAnimationController.ORDER_REVERSE);//出来的顺序

        view.setLayoutAnimation(lac);

    }
}
