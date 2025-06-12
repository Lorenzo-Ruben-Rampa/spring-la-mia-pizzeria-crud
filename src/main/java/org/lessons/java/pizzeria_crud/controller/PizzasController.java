package org.lessons.java.pizzeria_crud.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.lessons.java.pizzeria_crud.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.lessons.java.pizzeria_crud.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzasController {

    @Autowired
    private PizzasRepository repository;

    @GetMapping
    public String index (Model model) {
        List<Pizza>pizzas=repository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
}
