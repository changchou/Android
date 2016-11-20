package com.jikexueyuan.drawapi;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class RotatingRect extends View {

    public RotatingRect(Context context) {
        super(context);

        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs) {
        super(context, attrs);

        initProperties();
    }

    public RotatingRect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        initProperties();
    }

    private void initProperties() {
        p = new Paint();
        p.setColor(Color.RED);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        canvas.save();//保存
//        canvas.rotate(degrees);//旋转
        canvas.translate(200,200);//移动位置
        canvas.rotate(degrees,50,50);
        canvas.drawRect(0, 0, 100, 100, p);//位置大小

        degrees ++;
        canvas.restore();
        invalidate();//无效  -----就会重新绘制

    }

    private Paint p;
    private float degrees = 0;
}
