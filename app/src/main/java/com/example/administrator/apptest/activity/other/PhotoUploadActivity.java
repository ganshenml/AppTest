package com.example.administrator.apptest.activity.other;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.apptest.R;
import com.example.administrator.apptest.util.PhotoUtils;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class PhotoUploadActivity extends AppCompatActivity {
    private Button uploadBtn;
    Map<String , String> mapParams = new HashMap<String, String>();
    Map<String ,File> mapFiles = new HashMap<String, File>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_upload);
        uploadBtn = (Button) findViewById(R.id.uploadBtn);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("uploadBtn","点击了");
                        String url = "https://devapi.zczj.com:4460/api/MyCenter/UploadHeadPortrait";
                        mapParams.clear();
                        mapFiles.clear();
                        mapParams.put("token","30d9c9536f2862bbace07c288fb43a2b");
//                        File file = new File("/storage/sdcard1/dagudong_photo/20170211150020.png");
                        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"dagudong_photo"+File.separator+"20170211150020.png");
                        Log.e("imageUrl",file.getAbsolutePath());

                        mapFiles.put("img",file);

                        try {
                            PhotoUtils.post(url,mapParams,mapFiles);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }
}
