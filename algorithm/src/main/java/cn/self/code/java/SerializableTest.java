package cn.self.code.java;

import java.io.*;

/**
 * 对象序列化和反序列化测试
 * Created by zhaoliang on 2018/12/18.
 */
public class SerializableTest {

    public static void main(String[] args) {
        try {
            //序列化对象
            serializeClass();
            //反序列化对象
            deserializeClass();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serializeClass() throws IOException {
        Persion persion = new Persion();
        persion.setName("张三");
        persion.setColor("蓝色");
        persion.setAddress("上海市浦东新区");
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(new File("E:/serializeFile.txt")));
        stream.writeObject(persion);
        stream.flush();
        stream.close();
        System.out.println("序列化成功！");
    }

    public static void deserializeClass() throws IOException, ClassNotFoundException {
        ObjectInputStream stream = new ObjectInputStream(new FileInputStream(new File("E:/serializeFile.txt")));
        Persion persion = (Persion)stream.readObject();
        System.out.println("反序列化成功");
        System.out.println(persion.toString());
    }
}
