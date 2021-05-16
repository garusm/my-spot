package pl.garusm.myspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.garusm.myspot.entity.User;
import pl.garusm.myspot.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard")
    public String mainPage(){
        return "dashboard";
    }

    @GetMapping("/signup")
    public String addUserForm(Model model){
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String processAddUser(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/signup";
        }else {
            userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping("/signin")
    public String loginForm(User user, Model model){
        model.addAttribute("user", user);
        return "user/signin";
    }

    @PostMapping("/signin")
    public String processLogin(@Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "user/signin";
        }else {
            return "redirect:/";
        }

    }

    @GetMapping("/all")
    public String allTracks(Model model){
        model.addAttribute("users", userService.getUsers());
        return "user/all";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.getUser(id).orElseThrow(EntityNotFoundException::new));
        return "user/edit";
    }

    @PostMapping("/edit")
    public String processEditUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/user/edit";
        }else{
            userService.updateUser(user);
            return "redirect:/user/all";
        }
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable Long id, Model model){
        userService.deleteUser(id);
        return "redirect:/user/all";
    }
}
