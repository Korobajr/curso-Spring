package com.juanramon.springboot.curso.springbootcurso;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
        @PropertySource("classpath:values.properties"),
        @PropertySource("classpath:application.properties")
})

public class ValuesConfig {
}

