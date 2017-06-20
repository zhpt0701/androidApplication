package com.example.zhpt.mideoandvideo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //将activity存入本地堆栈中
        ActivityStack.getActivityStack(getApplication()).theCurrentSave(this);
    }
    //当整个应用推出时销毁多有的activity
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStack.getActivityStack(getApplication()).finshAll();
    }
}
