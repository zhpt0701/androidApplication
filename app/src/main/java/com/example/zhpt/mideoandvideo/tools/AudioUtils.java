package com.example.zhpt.mideoandvideo.tools;

import android.util.Log;

import com.example.zhpt.mideoandvideo.bean.Audio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/15 0015.
 */

public class AudioUtils {

    public List<Audio> list = new ArrayList<>();
    // 递归遍历
    public List<Audio> eachAllMedias(File f) {
        if (f != null && f.exists() && f.isDirectory()) {
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : f.listFiles()) {
                    if (file.isDirectory()) {
                        eachAllMedias(file);

                    } else if (file.exists() && file.canRead()
                            && isVideoOrAudio(file)) {
//                        list.add(file.getName());
                        Audio.getAudio().fileName = file.getName();
                        Audio.getAudio().path = file.getPath();
                        Log.i(AudioUtils.class.getName(),file.getName()+"  "+file.getPath());
                        list.add(Audio.getAudio());
                    }
                }
            }
        }
        return list;
    }
    /** 是否是音频或者视频
     * @throws Exception */
    public static boolean isVideoOrAudio(File f)  {
        final String ext = getFileExtension(f);
        ArrayList<String> list = new ArrayList<String>();
        list.add("avi");
        list.add("rmvb");
        list.add("wmv");
        list.add("mkv");
        list.add("mp4");

        return list.contains(ext);

    }

    /** 获取文件后缀
     * @throws Exception */
    public static String getFileExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }

        }
        return null;
    }
}
