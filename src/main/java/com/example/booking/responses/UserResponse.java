package com.example.booking.responses;

import com.example.booking.utils.RoleEnum;

import javax.persistence.Column;

public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private RoleEnum roleEnum;
    private String token;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String email, RoleEnum roleEnum) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleEnum = roleEnum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RoleEnum getRoleEnum() {
        return roleEnum;
    }

    public void setRoleEnum(RoleEnum roleEnum) {
        this.roleEnum = roleEnum;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
