package com.example.micronaut;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {
    @Get("/hello/{name}")
    public String sayHello(String name)
    {
        return "Hello " + name;
    }
}
