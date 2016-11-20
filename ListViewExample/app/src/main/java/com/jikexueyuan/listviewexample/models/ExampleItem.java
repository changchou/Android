package com.jikexueyuan.listviewexample.models;

/**
 * Created by Administrator on 2015/11/30 0030.
 */
public abstract class ExampleItem {

    private String label;

    public ExampleItem(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public abstract void onAction();

    @Override
    public String toString() {
        return label;
    }
}
