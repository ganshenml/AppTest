package com.example.administrator.apptest.activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.apptest.R;
import com.example.administrator.apptest.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ViewPagerAct extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabLayout.Tab projectTab,newsTab,discoveryTab,userCenterTab;

    private List<String> titleLsit = new ArrayList<>();
    private List<View> viewList  = new ArrayList<>();

    public ViewPagerAct() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        initViews();
        initData();
        initListeners();
    }

    private void initViews(){

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

    private void initData(){
        initTitleData();
        initViewData();
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titleLsit.get(3)));

        MyPageAdapter myPageAdapter = new MyPageAdapter(viewList,titleLsit);
        viewPager.setAdapter(myPageAdapter);
        tabLayout.setupWithViewPager(viewPager);//与viewPager使用同一个适配器，那么适配器数据变化时，tabLayout的数据也会跟着变化（如果注销掉，那么页面滑动时tabLayout的标题不会变），
                                                // 同样点击了tabLayout页会变动pagerAdapter的数据，那么ViewPager也会跟着变动；
        projectTab = tabLayout.getTabAt(0);
        projectTab.setIcon(R.mipmap.books);
        newsTab = tabLayout.getTabAt(0);
        newsTab.setIcon(R.mipmap.music);
        discoveryTab = tabLayout.getTabAt(0);
        discoveryTab.setIcon(R.mipmap.games);
        userCenterTab = tabLayout.getTabAt(0);
        userCenterTab.setIcon(R.mipmap.home);

    }

    private void initListeners(){
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ViewPager","点击了");
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("onPageScrolled",position+"滑动了");
            }

            @Override
            public void onPageSelected(int position) {
                Log.e("onPageSelected",position+"选定了");
//                tabLayout.getTabAt(position).setText(Html.fromHtml("<font size=\"32px\">"+tabLayout.getTabAt(position).getText().toString()+"</font>"));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e("ScrollStateChanged","改变了");
            }
        });

        tabLayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                Log.e("onFocusChange","焦点改变了");
            }
        });

    }

    ///////////////////////////////////////////
    private void initTitleData(){
        titleLsit.add("项目");
        titleLsit.add("资讯");
        titleLsit.add("发现");
        titleLsit.add("个人中心");
    }

    private void initViewData(){
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout2,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout3,null));
        viewList.add(layoutInflater.inflate(R.layout.pager_item_layout4,null));
    }
}
