package com.inkenka.devdemos.recycleview.multitype.delegate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.multitype.ItemData;


public class ImgAdapterDelegate<T extends ItemData> implements AdapterDelegate<T> {

    private Context mAppContext;

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        mAppContext = parent.getContext().getApplicationContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_img, parent, false);

        return new ImgItemHolder(view);
    }

    @Override
    public void bindData(T data, RecyclerView.ViewHolder holder) {
        ImgItemHolder itemHolder = (ImgItemHolder)holder;
        if(data.data instanceof Integer){
            itemHolder.mImageView.setImageDrawable(mAppContext.getResources().getDrawable((Integer) data.data));
        }
    }

    private class ImgItemHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;
        public View mRoot;

        public ImgItemHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }

}
