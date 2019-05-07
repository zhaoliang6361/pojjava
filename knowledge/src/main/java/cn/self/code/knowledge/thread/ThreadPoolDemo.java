package cn.self.code.knowledge.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoliang on 2019/5/7.
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = null;//
//        pool = Executors.newSingleThreadExecutor();
//        pool = Executors.newFixedThreadPool(5);
        pool = Executors.newCachedThreadPool();
//        pool = Executors.newScheduledThreadPool(5);
//        String url = "https://www.baidu.com";
//        String msg = Math.round(Math.random()* 100000000) + "";
//        String vccid = "123456";
//        Thread t1 = new ResponseThread (url,msg);
//        Thread t2 = new AcrThread (url,vccid,msg);
//        pool.execute(t1);
//        pool.execute(t2);
//        pool.shutdown();
        for(int i=0;i<10;i++){
            String url = "https://www.baidu.com";
            String msg = Math.round(Math.random()* 100000000) + "";
            pool.execute(new ResponseThread(url,msg));
        }
        pool.shutdown();
    }
}
