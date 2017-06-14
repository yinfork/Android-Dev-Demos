package com.inkenka.devdemos.recycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.inkenka.devdemos.R;
import com.inkenka.devdemos.recycleview.adapter.TextRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnimRecycleViewActivity extends AppCompatActivity {

    TextRecycleViewAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_demo);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(16));
        List<String> list = initData();
        mAdapter = new TextRecycleViewAdapter<>();
        mAdapter.setData(list);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());   // 添加增加、删除时动画
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("item" + i);
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_anim_recycleview, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                mAdapter.addData(1,"Added Item");
                break;
            case R.id.menu_remove:
                mAdapter.RemoveData(1);
                break;
        }
        return true;
    }

}
