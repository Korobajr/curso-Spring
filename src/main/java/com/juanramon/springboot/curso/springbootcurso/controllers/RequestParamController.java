package com.juanramon.springboot.curso.springbootcurso.controllers;

import com.juanramon.springboot.curso.springbootcurso.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {

    @Value("${config.username}")
    private String username;
    @Value("${config.message}")
    private String message;
    @Value("${config.code}")
    private Integer code;
    @Value("${config.listOfValues}")
    private String[] listOfValues;

    //Método con el que vemos como mandar parametros por requestParam que luego iran dentro de la url
    //localhost:8090/api/params/foo?message=algun mensaje
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue= "No hay mensaje") String message){

    ParamDto param = new ParamDto();
    param.setMessage(message);
    return param;
    }

    //Como enviar más de un parametro en la ruta url
    //Cuando queremos pasar mas de un parametro via url, lo que hacemos es separarlos con el simbolo &
    //localhost:8090/api/params/var?text=algun mensaje&code=12345
    @GetMapping("/var")
    public ParamDto var(@RequestParam String text, @RequestParam Integer code ){
        ParamDto params = new ParamDto();
        params.setMessage(text);
        params.setCode(code);
        return params;
    }

    //Alternativa a no utilizar anotaciones para obtener parametros inyectando de forma directa el objeto HttpServletRequest
    // a partir de este objeto podemos obtener los datos que estén incluidos en la url
    @GetMapping("/request")
    public ParamDto request(HttpServletRequest request){
        Integer code = 0;
        try {
            code = Integer.parseInt(request.getParameter("code"));
        }catch (NumberFormatException e){

        }
        ParamDto params = new ParamDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }

    @GetMapping("/values")
    public Map<String, Object> values(){
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);

        return json;
    }

}
