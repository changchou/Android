package com.jikexueyuan.learnrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
class MyAdapter extends RecyclerView.Adapter {

    class rvHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView tvTitle, tvContent;


        public rvHolder(View root) {
            super(root);

            tvTitle = (TextView) root.findViewById(R.id.tvTitle);
            tvContent = (TextView) root.findViewById(R.id.tvContent);
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new rvHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        rvHolder rvh = (rvHolder) holder;

        CellData cd = data[position];

        rvh.getTvTitle().setText(cd.title);
        rvh.getTvContent().setText(cd.content);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    private CellData[] data = new CellData[]{new CellData("标题1","内容1"),
            new CellData("标题2","内容2"),new CellData("标题3","内容3"),
            new CellData("标题4","内容4"),new CellData("标题4","内容4"),
            new CellData("标题5","内容5"),new CellData("标题6","内容6"),
            new CellData("标题7","内容7"),new CellData("标题8","内容8"),};
}
