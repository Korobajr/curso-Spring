package com.juanramon.springboot.curso.springbootcurso.controllers;

import com.juanramon.springboot.curso.springbootcurso.models.User;
import com.juanramon.springboot.curso.springbootcurso.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Otra forma de enviar datos a nuestro controller usando PathVariable, siempre es obligatorio pasar esa variable
//localhost:8090/api/var/baz/mi mensaje pasado como pathvariable
@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    //@Value es una anotación que nos permite inyectar configuraciones.
    @Value("${config.username}")
    private String username;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;
    //Distintos ejemplos con el Spring Language expresion
    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> valueList;
    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;
    @Value("#{${config.valuesMap}.product}")
    private String product;

    //El Objeto Environment nos permite leer configuraciones gracias a este bean de spring,
    @Autowired
    private Environment env;

    //Es más amistoso su uso con Api Rest
    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    //Otro ejemplo pasando varios parametros como pathVariable, esta vez utilizando un Objeto Map como respuesta.
    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mix(@PathVariable String product, @PathVariable Long id){
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);

        return json;
    }

    //Para crear nuevos usuarios en una bbdd usamos postman y pasamos el objeto User como RequestBody desde nuestro postman
    @PostMapping("/create")
    public User create(@RequestBody User user){
        // hacer algo con el susario para guardarlo en la bbdd
        return user;
    }

    @GetMapping("values")
    public Map<String, Object> values(@Value("${config.message}") String message){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("code2", env.getProperty("config.code"));
        json.put("message", message);
        json.put("message2",Integer.valueOf(env.getProperty("config.message")));
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valuesMap", valuesMap);
        json.put("product", product);

        return json;

    }
}
