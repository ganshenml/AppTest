package com.example.administrator.apptest.activity.other;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.example.administrator.apptest.R;

/**
 * Created by liuheng on 2015/8/19.
 */
public class ViewPagerActivity extends Activity {

    private ViewPager mPager;

    private int[] imgsId = new int[]{R.drawable.test, R.drawable.test2,R.drawable.test3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setPageMargin((int) (getResources().getDisplayMetrics().density * 15));
        mPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imgsId.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                PhotoView view = new PhotoView(ViewPagerActivity.this);
                view.enable();
                view.setScaleType(ImageView.ScaleType.FIT_CENTER);
                view.setImageResource(imgsId[position]);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }
        });
    }
}