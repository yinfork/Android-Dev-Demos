package com.inkenka.devdemos.MultiItemList.view;


import com.inkenka.devdemos.MultiItemList.DataBinder;
import com.inkenka.devdemos.MultiItemList.ListItemData;
import com.inkenka.devdemos.R;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class OnePicItemView extends RelativeLayout implements DataBinder {

    private ImageView mImageView;
    private TextView mTextView;

    public OnePicItemView(Context context) {
        this(context, null);
    }

    public OnePicItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OnePicItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        int paddingLeftRight = context.getResources().getDimensionPixelOffset(R.dimen.item_padding_left_right);
        int paddingTopBottom = context.getResources().getDimensionPixelOffset(R.dimen.item_padding_top_bottom);
        setPadding(paddingLeftRight, paddingTopBottom, paddingLeftRight, paddingTopBottom);

        LayoutInflater.from(context).inflate(R.layout.item_one_pic, this);
        mTextView = (TextView) findViewById(R.id.title);
        mImageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void bindData(Object object) {
        if(object instanceof ListItemData){
            ListItemData data = (ListItemData) object;
            String title;
            title = data.getName();

            if( !TextUtils.isEmpty(title)){
                mTextView.setText(title);
            } else {
                mTextView.setText("");
            }
            mImageView.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));
        }
    }
}
