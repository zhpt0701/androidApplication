package com.example.zhpt.mideoandvideo.tools;

/**
 * Created by Administrator on 2017/6/19 0019.
 */

public class Constent {
    private static Constent constent;
    public Constent(){

    }
    public static Constent getConstent(){
        if (constent == null){
            constent = new Constent();
        }
        return constent;
    }
    public int NUMBER_ZERO = 0;
    public int NUMBER_ONE = 1;
    public int NUMBER_TWO = 2;
    public int NUMBER_THREE = 3;
    public int NUMBER_FOUR = 4;
    public int NUMBER_FIVE = 5;
    public int NUMBER_TEN = 10;
}
