package adam.magazyn.controller;

import adam.magazyn.service.ProduktService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Validator;

@Controller
@RequestMapping("/produkty")
@Log
public class ProduktController {

    private final ProduktService produktService;

    public ProduktController(ProduktService produktService) {
        this.produktService = produktService;
    }

    @Autowired
    Validator validator;
}
