package com.inkenka.devdemos.recycleview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.LoadMoreTextRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RefreshRecycleViewActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_refresh_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);

        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_refresh_list);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(16));
        mList = initData();
        final LoadMoreTextRecycleViewAdapter<String> adapter = new LoadMoreTextRecycleViewAdapter<>();
        adapter.setData(mList);
        mRecyclerView.setAdapter(adapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mList.add(0,"refresh added Item");
                        mList.add(1,"refresh added Item");
                        mList.add(2,"refresh added Item");
                        mList.add(3,"refresh added Item");
                        adapter.setData(mList);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },1500);
            }
        });

        adapter.setOnLoadMoreListener(new LoadMoreTextRecycleViewAdapter.OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mList.add("load more added Item");
                        mList.add("load more added Item");
                        mList.add("load more added Item");
                        mList.add("load more added Item");
                        adapter.setData(mList);
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                },500);
            }
        });
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add("item" + i);
        }
        return list;
    }


}
