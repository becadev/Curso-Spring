package com.Apis.api.model;

public class User {
    private String name;
    public Long id;
    private String email;

    public User(){}
    public User(String name, Long id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString(){
        return "User:" + name +"\n" +
                "Id: " + id + "\n" +
                "Email: " + email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
