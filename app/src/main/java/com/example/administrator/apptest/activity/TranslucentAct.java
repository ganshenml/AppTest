package com.example.administrator.apptest.activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.apptest.R;

public class TranslucentAct extends AppCompatActivity {
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translucent);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
//                //将侧边栏顶部延伸至status bar
//                mDrawerLayout.setFitsSystemWindows(true);
//                //将主页面顶部延伸至status bar;虽默认为false,但经测试,DrawerLayout需显示设置
//                mDrawerLayout.setClipToPadding(false);
            }
        }
    }


    public void toNext(View view){
        startActivity(new Intent(this,MainActivity.class));
    }
}
