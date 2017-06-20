package com.example.zhpt.mideoandvideo.model;

import com.example.zhpt.mideoandvideo.bean.Audio;

/**
 * Created by Administrator on 2017/6/16 0016.
 */

public interface IntfaceAudio {
    void setTextViewName(String name);
    void setTextviewPath(String path);
    Audio load();
}
