package com.example.worldtour.controller;

import com.example.worldtour.dto.UserDto;
import com.example.worldtour.entity.User;
import com.example.worldtour.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register_admin")
    public String showSubAdminRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register_admin";
    }
    @PostMapping("/register_admin/save")
    public String createSubAdministrator(@Valid @ModelAttribute("user") UserDto userAdmin,
                                          BindingResult result,
                                          Model model){

        User existingUserAdmin = userService.findUserByEmail(userAdmin.getEmail());

        if(existingUserAdmin != null && existingUserAdmin.getEmail() != null && !existingUserAdmin.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userAdmin);
            return "/register_admin";
        }

        userService.saveUser(userAdmin);
        return "redirect:/register_admin?success";
    }
}
