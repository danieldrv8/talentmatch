package com.talentmatch.user_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    private String dasId;

    public User() {
    }

    public User(String userName, String email, String dasId) {
        this.userName = userName;
        this.email = email;
        this.dasId = dasId;
    }

    public String getDasId() {
        return dasId;
    }

    public void setDasId(String dasId) {
        this.dasId = dasId;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
