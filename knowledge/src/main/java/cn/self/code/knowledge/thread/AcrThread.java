package cn.self.code.knowledge.thread;

/**
 * Created by zhaoliang on 2019/5/7.
 */
public class AcrThread extends Thread {
    public String url;
    public String vccid;
    public String msg;

    public AcrThread(String url , String vccid, String msg){
        this.url = url;
        this.vccid = vccid;
        this.msg = msg;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " execute successful!");
    }
}
