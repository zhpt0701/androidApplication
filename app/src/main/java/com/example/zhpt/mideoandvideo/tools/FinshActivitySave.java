package com.example.zhpt.mideoandvideo.tools;

import android.app.Activity;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public interface FinshActivitySave {
    //保存当前activity
    void theCurrentSave(Activity activity);
    //获取当前最后一个插入的activity
    Activity getLastFirst();
    //获取第一插入的activity
    Activity getMoveFirst();
    //销毁当前activity
    void theCurrentFinsh(Activity activity);
    //根据类名销毁activity
    void classFinsh(Class<?> clas);
    //销毁所有的activity
    void finshAll();
}
