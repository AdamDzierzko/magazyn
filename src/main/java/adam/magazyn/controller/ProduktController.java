package adam.magazyn.controller;

import adam.magazyn.entity.Produkt;
import adam.magazyn.service.ProduktService;
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
@RequestMapping("/produkt")
@Log
public class ProduktController {

    private final ProduktService produktService;

    public ProduktController(ProduktService produktService) {
        this.produktService = produktService;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("produkt", new Produkt());
        return "produkt/add";
    }

    @PostMapping("/add")
    public String performNew(@Valid Produkt produkt, BindingResult result) {

        if (result.hasErrors()) {
            return "produkt/add";
        }
        produktService.save(produkt);
        return "redirect:/produkt/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("products", produktService.findAll());
        return "produkt/all";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        produktService.delete(id);
        return "redirect:/produkt/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("product", produktService.findOne(id));
        return "produkt/edit";
    }

    @PostMapping("/edit/*")
    public String editPreform(@Valid Produkt produkt, BindingResult result) {

        if (result.hasErrors()) {
            return "produkt/edit";
        }

        produktService.save(produkt);
        return "redirect:/produkt/all";
    }
}
