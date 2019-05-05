package cn.self.code.knowledge.thread;

/**
 * 静态内部类（推荐使用）
 * Created by zhaoliang on 2019/5/5.
 */
public class SingletonInner {
    private SingletonInner(){

    }
    private static class SingletonInstance{
        private static final SingletonInner INSTANCE = new SingletonInner();
    }
    public static SingletonInner getInstance() {
        return SingletonInstance.INSTANCE;
    }

    public void fun(){
        System.out.println(this + " :" + Thread.currentThread() );
    }
}
