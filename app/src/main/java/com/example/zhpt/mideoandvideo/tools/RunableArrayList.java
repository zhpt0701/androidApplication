package com.example.zhpt.mideoandvideo.tools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * Created by Administrator on 2017/6/19 0019.
 */

public class RunableArrayList {
    private ThreadPoolExecutor threadPoolExecutor = null;
    private static RunableArrayList runableArrayList;
    public RunableArrayList(){

    }
    //单利模式中的懒汉模式
    public static RunableArrayList getRunableArrayList(){
        if (runableArrayList == null){
            runableArrayList = new RunableArrayList();
        }
        return runableArrayList;
    }
    public void runable(Runnable runnable){
        if (threadPoolExecutor == null){
            int runableSize = Runtime.getRuntime().availableProcessors()*2+Constent.getConstent().NUMBER_ONE;
            //第一个参数是线程池正常情况下的线程（核心线程），第二个参数是线程池最大可容纳的线程
            //第三个参数空闲时间的线程数，第四个是空闲时间，第五个参数等待队列
            //第六个参数线程的创建工程，第七个参数是异常处理机制
            threadPoolExecutor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors()+Constent.getConstent().NUMBER_ONE,
                    runableSize,Constent.getConstent().NUMBER_ZERO, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(Constent.getConstent().NUMBER_TEN),
                    Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
        }
        try {
            threadPoolExecutor.execute(runnable);
        }catch (RejectedExecutionException e){
            e.printStackTrace();
        }
    }
    //清除等待区的任务
    public void clearRunable(Runnable runnable){
        if (threadPoolExecutor == null){
            threadPoolExecutor.getQueue().remove(runnable);//将任务从等待区移除
        }

    }
}
