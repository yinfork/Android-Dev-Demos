package com.inkenka.devdemos.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.TextRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnomalyGridRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        GridLayoutManager layoutManager = new GridLayoutManager(this,4);    // 一行四个宫格
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int index = position % 7;
                if (index == 0){
                    return 4;   // 占据4个宫格的位置，即MATCH_PARENT
                } else if (index > 0 && index < 3){
                    return 2;   // 占据2个宫格的位置，即父View宽度一半
                } else {
                    return 1;   // 占据1个宫格的位置，即父View宽度四分之一
                }
            }
        });

        mRecyclerView.setLayoutManager(layoutManager);
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
