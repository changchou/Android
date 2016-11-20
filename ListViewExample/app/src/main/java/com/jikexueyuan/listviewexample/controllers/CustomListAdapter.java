package com.jikexueyuan.listviewexample.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/1 0001.
 */
public class CustomListAdapter extends BaseAdapter {

    public CustomListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_cell, null);
            convertView.setTag(new CustomListCellViewHolder((TextView) convertView.findViewById(R.id.tvTitle), (TextView) convertView.findViewById(R.id.tvDesc)));
        }

//        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
//        TextView tvDesc = (TextView) convertView.findViewById(R.id.tvDesc);

        CustomListCellViewHolder vh = (CustomListCellViewHolder) convertView.getTag();

        Student item = getItem(position);
        vh.getTvTitle().setText(item.getName());
        vh.getTvDesc().setText("年龄:" + item.getAge());

        return convertView;
    }

    public Context getContext() {
        return context;
    }

    public void add(Student s) {
        students.add(s);
    }

    private List<Student> students = new ArrayList<>();
    private Context context;
}
