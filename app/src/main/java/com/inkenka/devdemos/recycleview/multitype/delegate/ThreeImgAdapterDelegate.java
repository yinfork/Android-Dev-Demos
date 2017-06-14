package com.inkenka.devdemos.recycleview.multitype.delegate;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.multitype.ItemData;

import java.util.List;

/**
 * Created by yinjianhua on 2017/6/14.
 */

public class ThreeImgAdapterDelegate<T extends ItemData> implements AdapterDelegate<T> {

    private Context mAppContext;

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        mAppContext = parent.getContext().getApplicationContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_three_img, parent, false);

        return new ImgItemHolder(view);
    }

    @Override
    public void bindData(T data, RecyclerView.ViewHolder holder) {
        ImgItemHolder itemHolder = (ImgItemHolder)holder;
        if(data.data instanceof List){
            itemHolder.mPic1.setImageDrawable(mAppContext.getResources().getDrawable((Integer) ((List) data.data).get(0)));
            itemHolder.mPic2.setImageDrawable(mAppContext.getResources().getDrawable((Integer) ((List) data.data).get(1)));
            itemHolder.mPic3.setImageDrawable(mAppContext.getResources().getDrawable((Integer) ((List) data.data).get(2)));
        }
    }

    private class ImgItemHolder extends RecyclerView.ViewHolder {
        public ImageView mPic1;
        public ImageView mPic2;
        public ImageView mPic3;
        public View mRoot;

        public ImgItemHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mPic1 = (ImageView) itemView.findViewById(R.id.iv_img1);
            mPic2 = (ImageView) itemView.findViewById(R.id.iv_img2);
            mPic3 = (ImageView) itemView.findViewById(R.id.iv_img3);
        }
    }

}
