package cn.self.code.knowledge.thread;

/**
 * Created by zhaoliang on 2019/5/7.
 */
public class ResponseThread extends Thread{

    private String url;
    private String message;
    public ResponseThread(String url , String message){
        this.url = url;
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println( Thread.currentThread().getName() + " add successful");
    }
}
