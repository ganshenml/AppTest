package com.example.administrator.apptest.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.administrator.apptest.R;
import com.example.administrator.apptest.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimplePagerAct extends AppCompatActivity {
    private List<View> viewList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private ViewPager simpleViewPager;
    private MyPageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_pager);
        initViews();
        initData();
        initListeners();
    }

    private void initViews(){
        simpleViewPager = (ViewPager) findViewById(R.id.simpleViewPager);

    }

    private void initData(){

        LayoutInflater layoutInflater = LayoutInflater.from(this);
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));

        titleList.add("标题1");
        titleList.add("标题2");
        titleList.add("标题3");
        titleList.add("标题4");
        titleList.add("标题5");

        pageAdapter = new MyPageAdapter(viewList,titleList);
        simpleViewPager.setAdapter(pageAdapter);

    }

    private void initListeners(){
    }
}
