package cn.self.code.java;

import java.io.Serializable;

/**
 * Created by zhaoliang on 2018/12/18.
 */
public class Persion implements Serializable {

    private static final long serialVersionUID = 1L;

    private static String age = "26";

    private String uid = "";

    private String name;

    private String color;

    private String address;

    private String gender;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
