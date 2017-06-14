package com.inkenka.devdemos.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.TextRecycleViewAdapter;
import com.inkenka.devdemos.recycleview.multitype.MultitypeRecycleViewActivity;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewDemoActivity extends AppCompatActivity implements TextRecycleViewAdapter.OnItemClickListener<String>{


    private final static String DEMO_SINGLE_TEXT = "单行列表";
    private final static String DEMO_GRID = "宫格";
    private final static String DEMO_ANOMALY_GRID = "不等分宫格";
    private final static String DEMO_ANIM = "增加删除动画";
    private final static String DEMO_WATERFALL = "瀑布流列表";
    private final static String DEMO_MULTITYPE = "多类型列表";
    private final static String DEMO_REFRESH = "下拉刷新和加载更多";



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
        adapter.setOnItemClickListener(this);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        list.add(DEMO_SINGLE_TEXT);
        list.add(DEMO_GRID);
        list.add(DEMO_ANOMALY_GRID);
        list.add(DEMO_ANIM);
        list.add(DEMO_WATERFALL);
        list.add(DEMO_MULTITYPE);
        list.add(DEMO_REFRESH);

        return list;
    }

    @Override
    public void onItemClick(int position, String data) {
        Intent intent = new Intent();
        switch (data){
            case DEMO_SINGLE_TEXT:
                intent.setClass(RecycleViewDemoActivity.this, SingleListRecycleViewActivity.class);
                break;
            case DEMO_GRID:
                intent.setClass(RecycleViewDemoActivity.this, GridRecycleViewActivity.class);
                break;
            case DEMO_ANOMALY_GRID:
                intent.setClass(RecycleViewDemoActivity.this, AnomalyGridRecycleViewActivity.class);
                break;
            case DEMO_ANIM:
                intent.setClass(RecycleViewDemoActivity.this, AnimRecycleViewActivity.class);
                break;
            case DEMO_WATERFALL:
                intent.setClass(RecycleViewDemoActivity.this, WaterfallRecycleViewActivity.class);
                break;
            case DEMO_MULTITYPE:
                intent.setClass(RecycleViewDemoActivity.this, MultitypeRecycleViewActivity.class);
                break;
            case DEMO_REFRESH:
                intent.setClass(RecycleViewDemoActivity.this, RefreshRecycleViewActivity.class);
                break;
        }

        startActivity(intent);
    }
}
