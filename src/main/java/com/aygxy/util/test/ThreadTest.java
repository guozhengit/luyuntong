package com.aygxy.util.test;

import java.util.concurrent.ThreadFactory;

/**
 * @Description: 线程测试
 * @Author: Guoyongzheng
 * @Date: 2019/4/18-10:33
 */
public class ThreadTest extends Throwable implements   Runnable {
    public String Thread1(Object o){
        new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };
        return null;
    }

    @Override
    public void run() {

    }
}
