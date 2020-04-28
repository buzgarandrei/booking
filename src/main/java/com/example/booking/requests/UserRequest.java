package com.example.booking.requests;

import com.example.booking.utils.RoleEnum;

public class UserRequest {

    private Long id;
    private String name;
    private String email;
    private RoleEnum roleEnum;
    private String password;

    public UserRequest() {
    }

    public UserRequest(Long id, String name, String email, RoleEnum roleEnum, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.roleEnum = roleEnum;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
