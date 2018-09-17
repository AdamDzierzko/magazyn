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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.Validator;
import java.time.LocalDateTime;

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

        czesci.setData(LocalDateTime.now());
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

        czesci.setData(LocalDateTime.now());
        czesciService.save(czesci);
        return "redirect:/czesci/all";
    }

    @GetMapping("/zmiana/{id}")
    public String zmiana(Model model, @PathVariable Long id) {
        model.addAttribute("czesci", czesciService.findOne(id));

        return "czesci/zmiana";
    }

    @PostMapping("/zmiana/*")
    public String zmianaPreform(Model model, @RequestParam String z, @RequestParam String i) {
        //  czesciService.zmianaIlości(zmiana);
        model.addAttribute("czesc", new Czesci());
        System.out.println(z);
        System.out.println(i);

        int a = Integer.parseInt(z);
        Long b = Long.parseLong(i);

        czesciService.zmianaIlości(a, b);
        return "redirect:/czesci/all";
    }

}
