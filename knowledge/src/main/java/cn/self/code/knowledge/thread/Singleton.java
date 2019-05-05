package cn.self.code.knowledge.thread;

/**
 * Created by zhaoliang on 2019/5/5.
 */
public class Singleton {

    private final static Singleton INSTANCE = new Singleton();

    /**
     *
     */
    private Singleton(){
        System.out.println("...... create instance ......");
    }

    public static Singleton getInstance(){
        return INSTANCE;
    }

    public void fun(){
        System.out.println(this + " :" + Thread.currentThread() );
    }
}
