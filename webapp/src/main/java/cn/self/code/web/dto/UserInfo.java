package cn.self.code.web.dto;

import java.io.Serializable;

/**
 * Created by zhaoliang on 2018/11/8.
 */
public class UserInfo implements Serializable{
    /**
     * use id
     */
    private int id;
    /**
     * user name
     */
    private String username;

    /**
     * password for login
     */
    private String password;

    /**
     * user address
     */
    private String address;

    /**
     * type of user
     */
    private int type;

    public UserInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", type=" + type +
                '}';
    }
}
