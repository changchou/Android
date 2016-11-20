package com.jikexueyuan.myrect;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class MyRect extends TextView {


    public MyRect(Context context, AttributeSet attrs) {
        super(context, attrs);


        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);

        int color = ta.getColor(R.styleable.MyView_rect_color, 0xffff0000);
        String string = ta.getString(R.styleable.MyView_text);
        setBackgroundColor(color);
        setText(string);
        setGravity(Gravity.CENTER);
        ta.recycle();


    }

    public MyRect(Context context) {
        super(context);
    }
}

