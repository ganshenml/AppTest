package com.example.administrator.apptest.activity.other;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.example.administrator.apptest.R;

public class RotateAnimationAct extends AppCompatActivity {
    private TextView rotateTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate_animation);

        rotateTv = (TextView) findViewById(R.id.rotateTv);

        RotateAnimation animation = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(3000);//设置动画持续时间
        animation.setRepeatCount(Animation.INFINITE);//设置重复次数
        rotateTv.setAnimation(animation);
        animation.start();
    }
}
