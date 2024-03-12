package com.juanramon.springboot.curso.springbootcurso.controllers;

import com.juanramon.springboot.curso.springbootcurso.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Con este Controller gestionamos las vistas de Timeleaft
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
        model.addAttribute("title", "Listado usuarios");
        return "list";
    }
    //Esta anotación nos permite pasar datos a la vista que sean comunes a la mayoria de metodos del controlador
    // es una forma de reutilizar datos.
    @ModelAttribute("users")
    public List<User> usersModel(){
        return Arrays.asList(new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@correo.com"),
                new User("Nanita", "Sarmiento"));
    }
}
