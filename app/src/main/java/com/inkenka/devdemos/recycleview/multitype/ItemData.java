package com.inkenka.devdemos.recycleview.multitype;

import android.support.annotation.IntDef;

public class ItemData<T> {

    public static final int TYPE_TEXT = 1;
    public static final int TYPE_IMG = 2;
    public static final int TYPE_THREE_IMG = 3;


    @IntDef({TYPE_TEXT, TYPE_IMG, TYPE_THREE_IMG})
    public @interface StyleType {
    }

    public ItemData(int styleType, T data){
        this.styleType = styleType;
        this.data = data;
    }

    public int styleType;
    public T data;
}
