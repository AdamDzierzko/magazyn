package adam.magazyn.controller;

import adam.magazyn.entity.Czesci;
import adam.magazyn.entity.TypCzesci;
import adam.magazyn.service.CzesciService;
import adam.magazyn.service.TypCzesciService;
import adam.magazyn.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.Validator;

@Controller
@RequestMapping("/czesci")
@Log
public class CzesciController {

    private final CzesciService czesciService;
    private final UserService userService;
    private final TypCzesciService typCzesciService;

    public CzesciController(CzesciService czesciService, UserService userService, TypCzesciService typCzesciService) {
        this.czesciService = czesciService;
        this.userService = userService;
        this.typCzesciService = typCzesciService;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("czesc", new Czesci());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("typCzesci", typCzesciService.findAll());
        return "czesci/add";
    }

    @PostMapping("/add")
    public String addNew(Model model, @Valid Czesci czesci, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            model.addAttribute("typCzesci", typCzesciService.findAll());
            return "czesci/add";
        }

        czesciService.save(czesci);
        return "redirect:/czesci/all";
    }

    @GetMapping("/all")
    public String findAll(Model model) {
        model.addAttribute("czesci", czesciService.findAll());
        return "czesci/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        czesciService.delete(id);
        return "redirect:/czesci/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("czesci", czesciService.findOne(id));
        model.addAttribute("users", userService.findAll());
        model.addAttribute("typCzesci", typCzesciService.findAll());
        return "czesci/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Czesci czesci, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("users", userService.findAll());
            model.addAttribute("typCzesci", typCzesciService.findAll());
            return "czesci/edit";
        }

        czesciService.save(czesci);
        return "redirect:/czesci/all";
    }

}