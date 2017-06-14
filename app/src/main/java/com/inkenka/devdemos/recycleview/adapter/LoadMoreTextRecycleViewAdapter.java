package com.inkenka.devdemos.recycleview.adapter;

import com.inkenka.devdemos.recycleview.adapter.TextRecycleViewAdapter;

/**
 * Created by yinjianhua on 2017/6/13.
 */

public class LoadMoreTextRecycleViewAdapter<T> extends TextRecycleViewAdapter<T> {

    private OnLoadMoreListener mOnLoadMoreListener;


    @Override
    public void onBindViewHolder(TextRecycleViewAdapter.ViewHolder holder, final int position) {
        super.onBindViewHolder(holder,position);
        if (position >= mList.size() - 1) {
            if (mOnLoadMoreListener != null) {
                mOnLoadMoreListener.onLoadMore();
            }
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }


    public void setOnLoadMoreListener(OnLoadMoreListener l) {
        mOnLoadMoreListener = l;
    }

}
