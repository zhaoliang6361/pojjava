package cn.self.code.knowledge.thread;

/**
 * 多线程
 * Created by zhaoliang on 2019/5/5.
 */
public class First {

    public static void main(String[] args) {
//        for(int i=0;i<15;i++){
//            new Thread(() ->{
//               Singleton instance = Singleton.getInstance();
//                instance.fun();
//            }).start();
//        }
//        System.out.println("***************** lazy *******************");
//        for(int i=0;i<15;i++){
//            new Thread(() ->{
//               SingletonLazy instance = SingletonLazy.getInstance();
//                instance.fun();
//            }).start();
//        }
//        System.out.println("***************** lazy *******************");
//        for(int i=0;i<15;i++){
//            new Thread(() ->{
//                SingletonLazy instance = SingletonLazy.getInstance2();
//                instance.fun();
//            }).start();
//        }
        System.out.println("***************** inner *******************");
        for(int i=0;i<15;i++){
            new Thread(() ->{
                SingletonInner instance = SingletonInner.getInstance();
                instance.fun();
            }).start();
        }
        System.out.println("***************** enum *******************");
        for(int i=0;i<15;i++){
            new Thread(() ->{
                SingletonEnum instance = SingletonEnum.INSTANCE;
                instance.fun();
            }).start();
        }
    }
}
