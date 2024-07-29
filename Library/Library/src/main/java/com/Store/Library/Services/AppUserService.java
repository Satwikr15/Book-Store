package com.Store.Library.Services;

import com.Store.Library.Models.AppUser;
import com.Store.Library.Repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private AppUserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser appUser= repo.findByEmail(email);

        if(appUser != null){
            var springUser = User.withUsername(appUser.getEmail())
                    .password(appUser.getPassword())
                    .build();
            return springUser;
        }

        return null;
    }
}
