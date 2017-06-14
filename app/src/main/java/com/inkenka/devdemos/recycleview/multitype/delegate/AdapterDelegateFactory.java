package com.inkenka.devdemos.recycleview.multitype.delegate;

import android.util.SparseArray;

import com.inkenka.devdemos.recycleview.multitype.ItemData;
import com.inkenka.devdemos.recycleview.multitype.delegate.AdapterDelegate;
import com.inkenka.devdemos.recycleview.multitype.delegate.ImgAdapterDelegate;
import com.inkenka.devdemos.recycleview.multitype.delegate.TextAdapterDelegate;
import com.inkenka.devdemos.recycleview.multitype.delegate.ThreeImgAdapterDelegate;


public class AdapterDelegateFactory<T extends ItemData> {

    private SparseArray<AdapterDelegate<T>> mDelagateArray = new SparseArray<>();

    public AdapterDelegate<T> getDelegate (int viewType) {
        AdapterDelegate<T> delegate =  mDelagateArray.get(viewType);
        if (delegate == null) {
            delegate = createAdapterDelegate(viewType);
            mDelagateArray.append(viewType, delegate);
        }
        return delegate;
    }

    private AdapterDelegate<T> createAdapterDelegate (@ItemData.StyleType int viewType) {
        switch (viewType) {
            case ItemData.TYPE_TEXT:
                return new TextAdapterDelegate<>();
            case ItemData.TYPE_IMG:
                return new ImgAdapterDelegate<>();
            case ItemData.TYPE_THREE_IMG:
                return new ThreeImgAdapterDelegate<>();
            default:
                return null;
        }
    }
}
