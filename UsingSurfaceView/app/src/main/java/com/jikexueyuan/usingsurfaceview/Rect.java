package com.jikexueyuan.usingsurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class Rect extends Container {

    private Paint paint = null;

    public Rect(){
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    @Override
    public void childrenView(Canvas canvas) {
        super.childrenView(canvas);
        canvas.drawRect(0,0,100,100,paint);
        this.setY(this.getY() + 1);
    }
}
