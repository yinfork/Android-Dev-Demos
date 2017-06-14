package com.inkenka.devdemos.recycleview.multitype;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.inkenka.devdemos.recycleview.multitype.delegate.AdapterDelegate;
import com.inkenka.devdemos.recycleview.multitype.delegate.AdapterDelegateFactory;

import java.util.List;


public class MultiRecycleViewAdapter<T extends ItemData> extends RecyclerView.Adapter {

    private List<T> mList;
    private AdapterDelegateFactory<T> mDelegateFactory = new AdapterDelegateFactory<>();

    public void setData(List<T> list){
        mList = list;
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterDelegate<T> delegate = mDelegateFactory.getDelegate(viewType);
        if (delegate == null) {
            throw new NullPointerException("delegate can not be null");
        }
        return delegate.createViewHolder(parent);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        AdapterDelegate<T> delegate = mDelegateFactory.getDelegate(viewType);
        if (delegate==null) {
            throw new NullPointerException("delegate is null cannot bind data");
        } else {
            delegate.bindData(mList.get(position), holder);
        }
    }

    @Override
    public int getItemViewType(int position) {
        ItemData item = getDataItem(position);
        if (item!=null) {
            return item.styleType;
        } else {
            return -1;
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public ItemData getDataItem (int position) {
        return null != mList && mList.size() > position ? mList.get(position) : null;
    }
}
