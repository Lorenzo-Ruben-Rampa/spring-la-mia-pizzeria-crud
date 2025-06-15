package org.lessons.java.pizzeria_crud.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.lessons.java.pizzeria_crud.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;
import org.lessons.java.pizzeria_crud.model.Pizza;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/pizzas")
public class PizzasController {

    @Autowired
    private PizzasRepository repository;

    @GetMapping
    public String index (Model model, @RequestParam(name="pizzaName", required=false) String searchPizzaName) {
        List<Pizza>pizzas;
            if (searchPizzaName != null && !searchPizzaName.isBlank()) {
                pizzas = repository.findByNameContainingIgnoreCase(searchPizzaName);
                model.addAttribute("searchPizzaName", searchPizzaName);
            } else {
                pizzas = repository.findAll();
            }
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    // @GetMapping("/{id}")
    //     public String pizzaDetail(Model model, @PathVariable("id") int id) {
    //     Optional<Pizza> result = repository.findById(id);
    //        if (result.isPresent()) {
    //         Pizza pizzaFound = result.get();
    //         model.addAttribute("pizza", pizzaFound);
    //         return "pizzaDetail";
    //     } else {
    //         throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con ID " + id + " non trovata.");
    //     }
    // }    
    
    @GetMapping("/{id}")
        public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", repository.findById(id).get());
        return "/pizzaDetail";
        }
}
