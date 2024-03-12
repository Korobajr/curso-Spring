package com.juanramon.springboot.curso.springbootcurso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/", "/home"})
    public  String home(){
        //Con esto redireccionamos una ruta hacia otra.
        //podriamos usar el fordwar y no se perderian parametros que existan dentro de la request, ya que con redirect
        //se pierden, tampoco cambia la ruta. El redirect carga nueva ruta, borra la request y refresca el navegador.
        return "redirect:/list";
        //return "forward:/list";
    }
}
