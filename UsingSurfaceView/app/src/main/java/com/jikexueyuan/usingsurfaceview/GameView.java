package com.jikexueyuan.usingsurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private Container container;
    private Rect rect;
    private Circle circle;

    public GameView(Context context) {
        super(context);
        container = new Container();
        rect = new Rect();
        circle = new Circle();
        rect.addChildrenView(circle);
        container.addChildrenView(rect);
        getHolder().addCallback(this);
    }

    public void draw(){
        Canvas canvas = getHolder().lockCanvas();
        canvas.drawColor(Color.WHITE);
        container.draw(canvas);
        getHolder().unlockCanvasAndPost(canvas);
    }

    private Timer timer = null;
    private TimerTask task = null;

    public void startTimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                draw();
            }
        };
        timer.schedule(task,100,100);
    }

    public void stopTimer(){
        if (timer != null){
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        startTimer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stopTimer();
    }
}
