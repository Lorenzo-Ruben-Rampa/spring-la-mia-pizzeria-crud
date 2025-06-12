package org.lessons.java.pizzeria_crud.repository;
import org.lessons.java.pizzeria_crud.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzasRepository extends JpaRepository <Pizza, Integer> {
    
}
