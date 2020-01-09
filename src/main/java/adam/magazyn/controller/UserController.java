package adam.magazyn.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import adam.magazyn.entity.User;
import adam.magazyn.service.UserService;
import lombok.extern.java.Log;

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
    
    @PostMapping("/gettime")
    @ResponseBody
    public String getServerTime () {
    	System.out.println("-----------getServerTime-----------");
    	Date d = new Date();
    	return d.toString();
    }

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

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());

        return "user/all";
   \ }
//sd
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOne(id));
        return "user/edit";
    }

 
 //   @PostMapping("/edit/")
    @RequestMapping(value = "/ed", method = RequestMethod.POST)
    public String editPerform(@RequestParam long id, @RequestParam String name, Model model) {
    	
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");

 //       if (result.hasErrors()) {
 //           return "user/edit";
 //       }

//        userService.save(user);
        return "redirect:/user/all";
    }
    
    /*
    @PostMapping("/edit/*")
    public String editPerform(@Valid User user, BindingResult result) {
    	
    	System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");

        if (result.hasErrors()) {
            return "user/edit";
        }

        userService.save(user);
        return "redirect:/user/all";
    }
    */


}
