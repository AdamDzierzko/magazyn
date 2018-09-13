package adam.magazyn.controller;

import adam.magazyn.entity.Czesci;
import adam.magazyn.service.CzesciService;
import lombok.extern.java.Log;
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
@RequestMapping("/czesci")
@Log
public class CzesciController {

    private final CzesciService czesciService;

    public CzesciController(CzesciService czesciService) {
        this.czesciService = czesciService;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("czesc", new Czesci());
        return "czesci/add";
    }

    @PostMapping("/add")
    public String addNew(@Valid Czesci czesci, BindingResult result) {

        if (result.hasErrors()) {
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

}
