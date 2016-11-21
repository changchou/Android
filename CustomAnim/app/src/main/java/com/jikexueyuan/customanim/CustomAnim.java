package com.jikexueyuan.customanim;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Administrator on 2015/12/7 0007.
 */
public class CustomAnim extends Animation {

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
//        System.out.println(">>>>>>>>>>>>");
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
//        System.out.println(interpolatedTime);
//        t.setAlpha(interpolatedTime);
//        t.getMatrix().setTranslate(200*interpolatedTime,200*interpolatedTime);
        t.getMatrix().setTranslate((float) (Math.sin(interpolatedTime*20)*50),0);//20周期   越大越快  50 振幅  越大越宽
        super.applyTransformation(interpolatedTime, t);
    }
}
