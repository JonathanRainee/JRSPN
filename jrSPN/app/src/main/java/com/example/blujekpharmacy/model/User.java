package com.example.blujekpharmacy.model;

import com.example.blujekpharmacy.MainActivity;
import com.example.blujekpharmacy.controller.Login;

public class User {
    private int ID;
    private String name;
    private String email;
    private String password;
    private String phone;
    public static User curr;

    public static int id = 1;

    public User(int ID, String name, String email, String password, String phone){
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String name, String email, String password, String phone){
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static User GET_USER(String email, String password) {
        for (User u: Login.userList) {
            if(u.email.equals(email) && u.password.equals(password)){
                return u;
            }
        }
        return null;
    }

    public static void INSERT_USER(User user) {
        Login.userList.add(user);
        id++;
        return;
    }

}
