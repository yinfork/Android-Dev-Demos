package com.inkenka.devdemos.MultiItemList.view;


import com.inkenka.devdemos.MultiItemList.DataBinder;
import com.inkenka.devdemos.MultiItemList.ListItemData;
import com.inkenka.devdemos.R;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ThreePicItemView extends LinearLayout implements DataBinder {

    private TextView mTextView;
    private ImageView mPic1View;
    private ImageView mPic2View;
    private ImageView mPic3View;


    public ThreePicItemView(Context context) {
        this(context, null);
    }

    public ThreePicItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ThreePicItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setOrientation(VERTICAL);
        int paddingLeftRight = context.getResources()
            .getDimensionPixelOffset(R.dimen.item_padding_left_right);
        int paddingTopBottom = context.getResources()
            .getDimensionPixelOffset(R.dimen.item_padding_top_bottom);
        setPadding(paddingLeftRight, paddingTopBottom, paddingLeftRight, paddingTopBottom);

        LayoutInflater.from(context).inflate(R.layout.item_three_pic, this);
        mTextView = (TextView) findViewById(R.id.title);
        mPic1View = (ImageView) findViewById(R.id.pic1);
        mPic2View = (ImageView) findViewById(R.id.pic2);
        mPic3View = (ImageView) findViewById(R.id.pic3);
    }

    @Override
    public void bindData(Object object) {
        if (object instanceof ListItemData) {
            ListItemData data = (ListItemData) object;
            String title;
            title = data.getName();

            if (!TextUtils.isEmpty(title)) {
                mTextView.setText(title);
            } else {
                mTextView.setText("");
            }
            mPic1View.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));
            mPic2View.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));
            mPic3View.setImageDrawable(getResources().getDrawable(R.drawable.item_img1));
        }
    }
}
