package com.inkenka.devdemos.recycleview.multitype.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.inkenka.devdemos.recycleview.multitype.ItemData;


public interface AdapterDelegate<T extends ItemData> {

    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent);

    public void bindData(T data, RecyclerView.ViewHolder holder);

}
