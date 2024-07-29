package com.Store.Library.Controllers;

import com.Store.Library.Models.AppUser;
import com.Store.Library.Models.RegisterDto;
import com.Store.Library.Repositories.AppUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    @Autowired
    private AppUserRepository repo;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute("registerDto", registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registerDto") RegisterDto registerDto, BindingResult result, Model model) {

        if(!registerDto.getPassword().equals(registerDto.getConfirmPassword())){
            result.addError(new FieldError("registerDto","confirmPassword","Password and Confirm Password do not match")
            );
        }
        AppUser appUser= repo.findByEmail(registerDto.getEmail());
        if(appUser != null){
            result.addError(new FieldError("registerDto","Email","Email address is already used")
            );
        }
        if (result.hasErrors()) {
            return "register";
        }
        try{
        var bCryptEncoder = new BCryptPasswordEncoder();

            AppUser newUser = new AppUser();
            newUser.setFirstname (registerDto.getFirstname());
            newUser.setLastname (registerDto.getLastname());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPhone (registerDto.getPhone());
            newUser.setAddress(registerDto.getAddress());
            newUser.setPassword (bCryptEncoder.encode(registerDto.getPassword()));

            repo.save(newUser);
        }
        catch(Exception ex){
            result.addError(new FieldError("registerDto","firstname",ex.getMessage()));
        }
        // Handle registration logic, e.g., saving user to the database
        model.addAttribute("registerDto", new RegisterDto());
        model.addAttribute("success", true);
        return "redirect:/success"; // Redirect to a success page or show a success message
    }

}
