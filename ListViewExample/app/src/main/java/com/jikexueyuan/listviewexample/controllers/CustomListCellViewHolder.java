package com.jikexueyuan.listviewexample.controllers;

import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/1 0001.
 */
public class CustomListCellViewHolder {

    private TextView tvTitle,tvDesc;

    public CustomListCellViewHolder(TextView tvTitle, TextView tvDesc) {
        this.tvTitle = tvTitle;
        this.tvDesc = tvDesc;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public TextView getTvDesc() {
        return tvDesc;
    }
}
