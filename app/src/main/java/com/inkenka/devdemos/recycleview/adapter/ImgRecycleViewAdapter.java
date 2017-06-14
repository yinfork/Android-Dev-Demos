package com.inkenka.devdemos.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.inkenka.devdemos.R;

import java.util.List;

/**
 * Created by yinjianhua on 2017/6/13.
 */

public class ImgRecycleViewAdapter<T> extends RecyclerView.Adapter<ImgRecycleViewAdapter.ViewHolder>  {

    private List<T> mList;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;

    public void setData(List<T> list){
        mList = list;
    }

    @Override
    public ImgRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_img, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ImgRecycleViewAdapter.ViewHolder holder, final int position) {
        if(getItemData(position) instanceof Integer) {
            holder.mImageView.setImageDrawable(mContext.getResources().getDrawable((Integer) getItemData(position)));
        }

        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != mOnItemClickListener) {
                    mOnItemClickListener.onItemClick(position, getItemData(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null != mList ? mList.size() : 0;
    }

    private T getItemData(int pos){
        return mList != null && mList.size() > pos ? mList.get(pos) : null;
    }

    public void addData(int position, T data){
        mList.add(position, data);
        //通知适配器item内容插入
        notifyItemInserted(position);
    }
    public void RemoveData(int position){
        mList.remove(position);
        //通知适配器item内容删除
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        View mRoot;
        public ViewHolder(View itemView) {
            super(itemView);
            mRoot = itemView;
            mImageView = (ImageView) itemView.findViewById(R.id.iv_img);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mOnItemClickListener = listener;
    }

    interface OnItemClickListener<T>{
        void onItemClick(int position, T data);
    }
}
