package adam.magazyn.controller;

import adam.magazyn.service.UserService;
import lombok.extern.java.Log;
import adam.magazyn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/user")
@Log
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    //
    @PostMapping("/add")
    public String performNew(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println("źle");
            return "user/add";
        }

        try {
            userService.save(user);
        } catch (Exception e) {
            return "user/add";
        }

        return "redirect:/user/all";
    }

}
