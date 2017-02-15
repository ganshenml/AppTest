package com.example.administrator.apptest.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/25.
 */

public class MyPageAdapter extends PagerAdapter {
    private List<View> viewList;
    private List<String> titleList;

    public MyPageAdapter(List<View> views){
        this.viewList = views;
    }

    public MyPageAdapter(List<View> views,List<String> stringList){
        this.viewList = views;
        this.titleList = stringList;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
