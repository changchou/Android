package com.jikexueyuan.usingsurfaceview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public class Circle extends Container {

    private Paint paint = null;

    public Circle(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
    }

    @Override
    public void childrenView(Canvas canvas) {
        super.childrenView(canvas);
        canvas.drawCircle(50,50,50,paint);
    }
}
