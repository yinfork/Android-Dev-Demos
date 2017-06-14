package com.inkenka.devdemos.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.ImgRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class WaterfallRecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        // 瀑布流布局
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

        mRecyclerView.addItemDecoration(new SpacesItemDecoration(16));

        List<Integer> list = initData();
        ImgRecycleViewAdapter<Integer> adapter = new ImgRecycleViewAdapter<>();
        adapter.setData(list);
        mRecyclerView.setAdapter(adapter);
    }

    private List<Integer> initData() {
        List<Integer> list = new ArrayList<>();
        list.add(R.drawable.naruto1);
        list.add(R.drawable.naruto2);
        list.add(R.drawable.naruto3);
        list.add(R.drawable.naruto4);
        list.add(R.drawable.naruto5);

        list.add(R.drawable.naruto1);
        list.add(R.drawable.naruto2);
        list.add(R.drawable.naruto3);
        list.add(R.drawable.naruto4);
        list.add(R.drawable.naruto5);

        list.add(R.drawable.naruto1);
        list.add(R.drawable.naruto2);
        list.add(R.drawable.naruto3);
        list.add(R.drawable.naruto4);
        list.add(R.drawable.naruto5);
        return list;
    }

}
