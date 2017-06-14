package com.inkenka.devdemos.recycleview.multitype.delegate;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.multitype.ItemData;

/**
 * Created by yinjianhua on 2017/6/14.
 */

public class TextAdapterDelegate<T extends ItemData> implements AdapterDelegate<T> {

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_text, parent, false);

        return new TextItemHolder(view);
    }

    @Override
    public void bindData(T data, RecyclerView.ViewHolder holder) {
        TextItemHolder itemHolder = (TextItemHolder)holder;
        if(data.data instanceof String){
            itemHolder.mTextView.setText((String) data.data);
        }
    }

    private class TextItemHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public View mRoot;

        public TextItemHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mTextView = (TextView) itemView.findViewById(R.id.title);
        }
    }

}
