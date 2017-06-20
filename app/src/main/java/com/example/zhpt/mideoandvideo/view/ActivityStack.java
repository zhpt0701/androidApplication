package com.example.zhpt.mideoandvideo.view;

import android.app.Activity;
import android.content.Context;

import com.example.zhpt.mideoandvideo.tools.FinshActivitySave;

import java.util.LinkedList;

/**
 * activity存储器
 * Created by Administrator on 2017/6/15 0015.
 */

public class ActivityStack implements FinshActivitySave {
    public static ActivityStack activityStack;

    public LinkedList<Activity> activities;
    //构造方法
    public ActivityStack(){
        if (activities == null){
            activities = new LinkedList<>();
        }
    }

    /**
     * 单例模式
     * @param context
     * @return
     */
    public static ActivityStack getActivityStack(Context context){
        if (activityStack == null){
            activityStack = new ActivityStack();
        }
        return activityStack;
    }

    /**
     * 存储activity
     * @param activity
     */
    @Override
    public void theCurrentSave(Activity activity) {
        if (activity != null){
            activities.add(activity);
        }
    }
    //获取最后一个
    @Override
    public Activity getLastFirst() {
        return activities.getLast();
    }
    //获取第一个
    @Override
    public Activity getMoveFirst() {
        return activities.getFirst();
    }

    /**
     * 根据类名销毁activity
     * @param activity
     */
    @Override
    public void theCurrentFinsh(Activity activity) {
        if (activity != null){
            activities.remove(activity);
            activity.finish();
        }
    }

    /**
     * 根据类名销毁activity
     * @param clas
     */
    @Override
    public void classFinsh(Class<?> clas) {
        if (clas != null){
            for (Activity activity:activities){
                if (activity.getClass().getName().equals(clas)){
                    theCurrentFinsh(activity);
                    return;
                }
            }
        }
    }
    //销毁所有的activity
    @Override
    public void finshAll() {
        if (activities != null){
            for (Activity activity:activities){
                activity.finish();
            }
            activities.clear();
        }
    }
}
