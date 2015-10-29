package com.artivisi.aplikasi.payroll.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "c_security_user_password")
public class UserPassword {
    @Id @Column(name="id_user")
    private String id;

    @OneToOne @MapsId
    @JoinColumn(name = "id_user")
    private User user;
    
    @Column(nullable = false, name = "user_password")
    private String password;

    public UserPassword() {
    }

    public UserPassword(User user, String password) {
        this.user = user;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
