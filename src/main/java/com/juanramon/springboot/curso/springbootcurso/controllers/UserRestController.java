package com.juanramon.springboot.curso.springbootcurso.controllers;

import com.juanramon.springboot.curso.springbootcurso.models.User;
import com.juanramon.springboot.curso.springbootcurso.models.dto.UserDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {
    //El RestController nos ofrece un servicio web, nos devolverá un objeto json.

    @GetMapping(path = "/details-map")
    public Map<String, Object> detailsMap() {
        User newUser = new User("Andres", "Pereira");
        Map<String, Object> response = new HashMap<>();
        response.put("Title", "Hola Mundo Spring Boot" );
        response.put("user", newUser);
        return response;
    }

    @GetMapping(path = "/details")
    public UserDto details() {

        UserDto userDto = new UserDto();

        User newUser = new User("Andres", "Pereira");
        userDto.setUser(newUser);

        userDto.setTitle("Hola Mundo Spring Boot" );

        return userDto;
    }
    @GetMapping("/list")
    public List<User> list(){
        User newUser = new User("Andres", "Pereira");
        User newUser2 = new User("Juan", "Guti");
        User newUser3 = new User("Pedro", "Ñoclo");
       /* List<User> listUsers = new ArrayList<>();
        listUsers.add(newUser);
        listUsers.add(newUser2);
        listUsers.add(newUser3);*/
        // Mismo resultado pero usando una Clase Helper "Arrays"
        List<User> listUsers = Arrays.asList(newUser, newUser2, newUser3);

        return listUsers;
    }
}
