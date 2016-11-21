package com.jikexueyuan.dragthepic;

import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private View rootView;
    private int actionBarHeight;
    private int notifiHeight;
    private int topHeight;
    private int diffX;
    private int diffY;
    private ImageView moveImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        rootView.post(new Runnable() {
            @Override
            public void run() {

                if (getSupportActionBar() != null) {
                    //APP标题栏高度
                    actionBarHeight = getSupportActionBar().getHeight();

                    //通知栏高度
                    Rect frame = new Rect();
                    getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
                    notifiHeight = frame.top;

                    topHeight = actionBarHeight + notifiHeight;
                }
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int actionTag = MotionEventCompat.getActionMasked(event);
        int pointIndex = MotionEventCompat.getActionIndex(event);
        switch (actionTag) {
            case MotionEvent.ACTION_DOWN:
//                System.out.println(String.format("x:%f\n,y:%f", event.getX(), event.getY()));

                //判断触摸点是否在要移动的图片上
                LinearLayout.LayoutParams downParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                if (event.getX() > downParams.leftMargin &&
                        event.getX() < downParams.leftMargin + imageView.getWidth() &&
                        event.getY() > downParams.topMargin + topHeight &&
                        event.getY() < downParams.topMargin + topHeight + imageView.getHeight()) {

                    moveImage = imageView;

                    diffX = (int) (event.getX() - downParams.leftMargin);
                    diffY = (int) (event.getY() - topHeight - downParams.topMargin);
                }

                break;
            case MotionEvent.ACTION_MOVE:

                if (moveImage != null) {
                    LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                    params.leftMargin = (int) (MotionEventCompat.getX(event, pointIndex) - diffX);
                    params.topMargin = (int) (MotionEventCompat.getY(event, pointIndex) - topHeight - diffY);
                    imageView.setLayoutParams(params);
                }


//                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) imageView.getLayoutParams();
//                lp.leftMargin = (int) event.getX();
//                lp.topMargin = (int) event.getY();
//                imageView.setLayoutParams(lp);


                break;
            case MotionEvent.ACTION_UP:
                moveImage = null;
                break;
        }

        return super.onTouchEvent(event);
    }
}
