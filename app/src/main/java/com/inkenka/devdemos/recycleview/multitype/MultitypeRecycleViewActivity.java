package com.inkenka.devdemos.recycleview.multitype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class MultitypeRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(16));
        List<ItemData> list = initData();
        MultiRecycleViewAdapter<ItemData> adapter = new MultiRecycleViewAdapter<>();
        adapter.setData(list);
        mRecyclerView.setAdapter(adapter);
    }

    private List<ItemData> initData() {
        List<Integer> imgs = new ArrayList<>();
        imgs.add(R.drawable.naruto1);
        imgs.add(R.drawable.naruto2);
        imgs.add(R.drawable.naruto3);

        List<ItemData> list = new ArrayList<>();
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 1"));
        list.add(new ItemData(ItemData.TYPE_THREE_IMG, imgs));
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 2"));
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 3"));
        list.add(new ItemData(ItemData.TYPE_IMG, R.drawable.naruto1));
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 4"));
        list.add(new ItemData(ItemData.TYPE_THREE_IMG, imgs));
        list.add(new ItemData(ItemData.TYPE_IMG, R.drawable.naruto2));
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 5"));
        list.add(new ItemData(ItemData.TYPE_IMG, R.drawable.naruto3));
        list.add(new ItemData(ItemData.TYPE_TEXT, "item 6"));
        list.add(new ItemData(ItemData.TYPE_IMG, R.drawable.naruto4));
        list.add(new ItemData(ItemData.TYPE_THREE_IMG, imgs));
        list.add(new ItemData(ItemData.TYPE_IMG, R.drawable.naruto5));
        return list;
    }

}
