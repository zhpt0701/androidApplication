package com.example.zhpt.mideoandvideo.bean;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class Audio {
    private static Audio audio;
    public Audio(){
//        this.fileName = fileName;
//        this.path = path;
    }
    public static Audio getAudio(){
        if (audio == null){
            audio = new Audio();
        }
        return audio;
    }
    public String fileName;
    public String path;

    public String getFileName(){
        return fileName;
    }

    public String getPath(){
        return path;
    }

}
