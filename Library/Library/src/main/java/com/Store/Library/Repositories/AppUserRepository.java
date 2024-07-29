package com.Store.Library.Repositories;

import com.Store.Library.Models.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    public AppUser findByEmail(String email);
}
