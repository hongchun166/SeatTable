package com.thc.myapplication.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by TianHongChun on 2016/9/6.
 */
public class MThreadManager {
    ExecutorService pool = Executors.newFixedThreadPool(3);
    public static MThreadManager manager;
    public static synchronized MThreadManager getInstant(){
        if(manager==null)
            manager=new MThreadManager();
        return manager;
    }
    private MThreadManager(){}
    public void run(Runnable runnable){
        if(pool==null){
            pool = Executors.newFixedThreadPool(3);
        }
        pool.execute(runnable);
    }
    public void shutdown(){
        if(pool==null) return;
        pool.shutdown();
        pool.shutdownNow();
        pool=null;
    }
}
