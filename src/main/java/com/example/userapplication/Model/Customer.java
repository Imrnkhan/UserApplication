package com.example.userapplication.Model;

import javax.persistence.*;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;
    private String username;
    private Integer password;
    private String fullname;
    private String email;
    private  Integer phone;
    @ManyToOne
    @JoinColumn(name = "login_login_id")
    private Login login;


    public Customer() {

    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Customer(Integer userid, String username, Integer password, String fullname, String email, Integer phone) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public int getUserId() {
        return 0;
    }
}
