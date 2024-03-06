package com.juanramon.springboot.curso.springbootcurso.controllers;

import com.juanramon.springboot.curso.springbootcurso.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model) {
        //Como pasamos datos a la vista. Podemos hacerlo con el objeto Model, o con un Map

        User newUser = new User("Andres", "Pereira");
        model.addAttribute("Title", "Hola Mundo Spring Boot" );
        model.addAttribute("user", newUser);

        return "details";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<User> users = Arrays.asList(new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Nanita", "Sarmiento"));
        model.addAttribute("users", users);
        model.addAttribute("title", "Listado usuarios");
        return "list";
    }
}
