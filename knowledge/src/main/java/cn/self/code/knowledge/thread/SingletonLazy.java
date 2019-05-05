package cn.self.code.knowledge.thread;

/**
 * 线程不安全
 * Created by zhaoliang on 2019/5/5.
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy(){
        System.out.println("...... create instance ......");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程不安全
     * @return
     */
    public static SingletonLazy getInstance(){
        if(instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 线程安全但是效率低
     * @return
     */
    public static synchronized SingletonLazy getInstance2(){
        if(instance==null){
            instance = new SingletonLazy();
        }
        return instance;
    }

    /**
     * 线程安全但是不推荐使用
     * @return
     */
    public static  SingletonLazy getInstance3(){
        if(instance==null){
            synchronized(SingletonLazy.class){
                instance = new SingletonLazy();
            }
        }
        return instance;
    }

    public static  SingletonLazy getInstance4(){
        if(instance==null){
            synchronized(SingletonLazy.class){
                if(instance==null){
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }
    public void fun(){
        System.out.println(this + " :" + Thread.currentThread() );
    }
}
