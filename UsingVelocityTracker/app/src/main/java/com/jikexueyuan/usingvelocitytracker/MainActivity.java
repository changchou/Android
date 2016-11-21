package com.jikexueyuan.usingvelocitytracker;

import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;

public class MainActivity extends AppCompatActivity {

    private VelocityTracker velocityTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (velocityTracker == null) {
                    velocityTracker = VelocityTracker.obtain();
                } else {
                    velocityTracker.clear();
                }
                velocityTracker.addMovement(event);
                break;
            case MotionEvent.ACTION_MOVE:
                velocityTracker.addMovement(event);
                velocityTracker.computeCurrentVelocity(1000);
                System.out.println(String.format("X轴的速度：%f\tY轴的速度：%f",
                        VelocityTrackerCompat.getXVelocity(velocityTracker, MotionEventCompat.getPointerId(event,MotionEventCompat.getActionIndex(event))),
                        VelocityTrackerCompat.getYVelocity(velocityTracker, MotionEventCompat.getPointerId(event, MotionEventCompat.getActionIndex(event)))));
                        //velocityTracker.getXVelocity()
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                velocityTracker.recycle();
                break;
        }

        return false;
    }
}
