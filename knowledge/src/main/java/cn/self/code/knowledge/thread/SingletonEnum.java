package cn.self.code.knowledge.thread;

/**
 * Created by zhaoliang on 2019/5/5.
 */
public enum SingletonEnum {
    INSTANCE;

    public void fun(){
        System.out.println(this + " :" + Thread.currentThread() );
    }
}
