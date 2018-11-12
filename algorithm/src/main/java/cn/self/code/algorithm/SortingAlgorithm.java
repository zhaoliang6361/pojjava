package cn.self.code.algorithm;

/**
 * Created by zhaoliang on 2018/11/12.
 */
public class SortingAlgorithm {

    /**
     * 插入排序
     * @param in
     */
    public void insertArray(Integer[] in){
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                num++;
                if ( in [j + 1] < in [j]) {
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    upnum++;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("插入排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }



    //选择排序
    public void chooseArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = 0; j < in .length - 1; j++) {
                num++;
                if ( in [j + 1] < in [j]) {
                    tem = in [j + 1]; in [j + 1] = in [j]; in [j] = tem;
                    upnum++;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("选择排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }
    //冒泡排序
    public void efferArray(Integer[] in ) {
        int tem = 0;
        int num = 0;
        int upnum = 0;
        for (int i = 0; i < in .length; i++) {
            for (int j = i; j < in .length - 1; j++) {
                num++;
                if ( in [j + 1] < in [i]) {
                    tem = in [j + 1]; in [j + 1] = in [i]; in [i] = tem;
                    upnum++;
                }
            }
        }
        for (int i = 0; i < in .length; i++) {
            System.out.print( in [i]);
            if (i < in .length - 1) {
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("冒泡排序循环次数:" + num);
        System.out.println("移动次数：" + upnum);
        System.out.print("\n\n\n");
    }

    /**
     * 主方法
     * @param args
     */
    public static void main(String[] args){
        SortingAlgorithm instance  = new SortingAlgorithm();
        Integer in [] = {
                8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
        };
        instance.insertArray(in); //插入排序

        Integer in1[] = {
                8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
        };
        instance.chooseArray(in1);
        Integer in2[] = {
                8, 89, 5, 84, 3, 45, 12, 33, 77, 98, 456, 878, 654, 213, 897
        };
        instance.efferArray(in2);
    }
}
