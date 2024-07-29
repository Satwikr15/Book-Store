package com.Store.Library.Models;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    @Column(unique = true,nullable = false)
    private String email;

    private String phone;
    private String address;
    private String password;

    public int getId() {
        return id;
    }

    public AppUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public AppUser setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public AppUser setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public AppUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AppUser setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public AppUser setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AppUser setPassword(String password) {
        this.password = password;
        return this;
    }


}

