package com.example.zhpt.mideoandvideo.presenter;


import android.os.Handler;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class MideoAndViceoPresenter {

    public Handler handler = new Handler();
    public MideoAndViceoPresenter(){

    }
    public void m(){
        handler.post(runnable);
    }
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };
}
