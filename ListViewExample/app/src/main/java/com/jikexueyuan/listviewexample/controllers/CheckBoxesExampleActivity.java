package com.jikexueyuan.listviewexample.controllers;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

import com.jikexueyuan.listviewexample.R;
import com.jikexueyuan.listviewexample.models.CheckBoxItem;

public class CheckBoxesExampleActivity extends ListActivity {

    private ArrayAdapter<CheckBoxItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ArrayAdapter<CheckBoxItem>(this,android.R.layout.simple_list_item_multiple_choice){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                CheckedTextView ctv = (CheckedTextView) super.getView(position,convertView,parent);

                CheckBoxItem item = getItem(position);
                ctv.setChecked(item.isChecked());

                return ctv;
            }
        };
        setListAdapter(adapter);

//        adapter.add("Hello");
//        adapter.add("World");
//        adapter.add("Android");

        for (int i = 0;i < 100;i++){
            adapter.add(new CheckBoxItem("Item" + i,false));
        }

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

//        CheckedTextView ctv = (CheckedTextView) v;
//        ctv.setChecked(!ctv.isChecked());

        CheckBoxItem item = adapter.getItem(position);
        item.setChecked(!item.isChecked());

        adapter.notifyDataSetChanged();
    }
}
