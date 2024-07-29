package com.Store.Library.Models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDto {
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    @Email
    private String email;
    private String phone;
    private String address;
    @Size(min=6, message="Minimum Password length is 6 characters")
    private String password;
    private String confirmPassword;

    public String getFirstname() {
        return firstname;
    }

    public RegisterDto setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public RegisterDto setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RegisterDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public RegisterDto setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public RegisterDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public RegisterDto setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
