package com.example.administrator.apptest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.apptest.LottieAnimationAct;
import com.example.administrator.apptest.R;

public class TestListenerAct extends AppCompatActivity {
    private Button testBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_listener);
        testBtn = (Button)findViewById(R.id.testBtn);
        testBtn.setOnClickListener(new samsungpaybtnCheckedListener());
    }

    class samsungpaybtnCheckedListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TestListenerAct.this, LottieAnimationAct.class);
            startActivity(intent);
        }
    }
}
