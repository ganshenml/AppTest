package com.example.administrator.apptest.activity;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.apptest.R;
import com.example.administrator.apptest.callback.JsonCallBack;
import com.example.administrator.apptest.entity.NewsListEntity;
import com.example.administrator.apptest.entity.PlateEntity;
import com.example.administrator.apptest.http.Request;
import com.example.administrator.apptest.http.RequestManager;
import com.example.administrator.apptest.util.AppException;
import com.example.administrator.apptest.util.Common;
import com.example.administrator.apptest.util.StringUtils;
import com.google.gson.Gson;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button getProvinceInfoBtn, sbBtn,searchBtn;
    private EditText searchEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getProvinceInfoBtn = (Button) findViewById(R.id.getProvinceInfoBtn);
        sbBtn = (Button) findViewById(R.id.sbBtn);
        searchBtn = (Button) findViewById(R.id.searchBtn);
        searchEt = (EditText)findViewById(R.id.searchEt);

        getProvinceInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPlateListData();
            }
        });
        sbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(sbBtn, "这是Snackbar", Snackbar.LENGTH_LONG).setAction("hahha", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "这是Toast", Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.getView().setBackgroundColor(Color.RED);
                snackbar.show();
            }
        });

        searchBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.getProvinceInfoBtn:
                Toast.makeText(getApplicationContext(), "点击了第一按钮", Toast.LENGTH_LONG).show();

                break;
            case R.id.searchBtn:
                doSearch();
                break;
            default:
                break;
        }
    }

    /**
     * 获取平台信息
     */
    private void getPlateListData() {
        HashMap<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.clear();
        final Request request = new Request("/Help/GetAllPlate", Request.RequestMethod.GET, requestMap);
        request.setCallBack(new JsonCallBack<PlateEntity>() {
            @Override
            public void onFailure(AppException result) {

            }

            @Override
            public void onSuccess(PlateEntity result) {
                String resultStr = new Gson().toJson(result);
                Log.e("resultStr", resultStr);
            }
        }.setReturnClass(PlateEntity.class));
        RequestManager.getInstance().performRequest(request);
    }

    /**
     * 搜索关键词返回结果
     */
    private void doSearch(){
        HashMap<String, Object> requestMap = new HashMap<String, Object>();
        String keyWordsStr  = searchEt.getText().toString().trim();
        if (StringUtils.isEmpty(keyWordsStr)) {
            Log.e("搜索关键词","关键词为空，返回");
            return;
        }

        keyWordsStr = Common.toURLEncoded(keyWordsStr);
        requestMap.clear();
        requestMap.put("pagesize", 20);
        requestMap.put("currentpage",1);
        requestMap.put("keyword",keyWordsStr);
        Request request = new Request("/News/GetSearchByKeyword", Request.RequestMethod.GET, requestMap);
        request.setCallBack(new JsonCallBack<NewsListEntity>() {
            @Override
            public void onFailure(AppException result) {

            }

            @Override
            public void onSuccess(NewsListEntity result) {

            }
        }.setReturnClass(NewsListEntity.class));
        RequestManager.getInstance().performRequest(request);

    }
}
