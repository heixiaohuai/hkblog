package com.hk.hkblog.entity;

/**
 * @author by 何坤
 * @Classname User
 * @Description TODO
 * @Date 2019/9/17 9:30
 */
public class User {
    private String username;
    private Integer age;

    public User() {
    }

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
