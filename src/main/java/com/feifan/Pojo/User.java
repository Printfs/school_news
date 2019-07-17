package com.feifan.Pojo;

public class User {
    private int userId;
    private String name;
    private String password;
    private String publisher;
    private int status;

    public User() {
    }

    public User(int userId, String name, String password, String publisher, int status) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.publisher = publisher;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status=" + status +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
