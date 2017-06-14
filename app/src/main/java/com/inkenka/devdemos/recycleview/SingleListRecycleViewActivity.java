package com.inkenka.devdemos.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.TextRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class SingleListRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(16));
        List<String> list = initData();
        TextRecycleViewAdapter<String> adapter = new TextRecycleViewAdapter<>();
        adapter.setData(list);
        mRecyclerView.setAdapter(adapter);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("item" + i);
        }
        return list;
    }

}
