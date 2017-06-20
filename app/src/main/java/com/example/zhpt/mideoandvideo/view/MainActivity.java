package com.example.zhpt.mideoandvideo.view;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.example.zhpt.mideoandvideo.R;
import com.example.zhpt.mideoandvideo.tools.AudioUtils;
import com.example.zhpt.mideoandvideo.view.adapter.ListAdapter;

import java.io.File;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class MainActivity extends BaseActivity {
    private ListView listView;
    private AudioUtils audioUtils;
    private ListAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //初始化数据
        initData();
        //初始化控件
        initView();
    }

    private void initView() {
        listView = (ListView)findViewById(R.id.list_item);
        adapter = new ListAdapter(getApplication(),audioUtils.eachAllMedias(new File(Environment.getExternalStorageDirectory().getPath())));
        listView.setAdapter(adapter);
    }

    private void initData() {
        audioUtils = new AudioUtils();
    }
}
