package com.feifan.pojo;

public class User {
    private int userId;
    private String name;
    private String password;
    private String publisher;
    private int status;
    private String email;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int userId, String name, String password, String publisher, int status, String email) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.publisher = publisher;
        this.status = status;
        this.email = email;
    }
}
