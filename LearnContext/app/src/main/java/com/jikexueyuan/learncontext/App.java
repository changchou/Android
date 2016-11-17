package com.jikexueyuan.learncontext;

import android.app.Application;

/**
 * Created by Administrator on 2015/10/24 0024.
 */
public class App extends Application{
    private String textData = "default";

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getTextData() {
        return textData;
    }
}
