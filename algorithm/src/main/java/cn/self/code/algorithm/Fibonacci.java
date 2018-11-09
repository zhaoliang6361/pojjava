package cn.self.code.algorithm;

/**
 *  费式数列
 *  Fibonacci为1200年代的欧洲数学家，在他的着作中曾经提到：「若有一只免子每个月生一只小免
 *  子，一个月后小免子也开始生产。起初只有一只免子，一个月后就有两只免子，二个月后有三
 *  只免子，三个月后有五只免子（小免子投入生产）......。
 *  如果不太理解这个例子的话，举个图就知道了，注意新生的小免子需一个月成长期才会投入生
 *  产，类似的道理也可以用于植物的生长，这就是Fibonacci数列，一般习惯称之为费氏数列，例
 *  如以下： 1、1 、2、3、5、8、13、21、34、55、89......
 *  解法
 *  依说明，我们可以将费氏数列定义为以下：
 *  fn = fn-1 + fn-2
 *  fn = n
 *  if n > 1
 *  if n = 0, 1
 *  Created by zhaoliang on 2018/11/9.
 */
public class Fibonacci {

    private static int a = 20;

    public static void main(String[] args){
        int result = fun(a);
        System.out.println(result);
    }

    /**
     * 根据算法公式
     * @param num
     * @return
     */
    public static int fun(int num){
        if(num <= 0){
            return 0;
        } else if(num == 1 ){
            return 1;
        } else if(num == 2) {
            return 2;
        } else {
            return fun(num -1 ) + fun(num - 2);
        }
    }
}
