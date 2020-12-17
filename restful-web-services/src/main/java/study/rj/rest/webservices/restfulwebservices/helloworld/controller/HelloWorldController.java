package study.rj.rest.webservices.restfulwebservices.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;
import study.rj.rest.webservices.restfulwebservices.helloworld.model.HelloWorldBean;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld(@RequestParam(name = "name", defaultValue = "World") String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(@RequestParam(name = "message", defaultValue = "Hello World") String message) {
        return new HelloWorldBean(message);
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable(name = "name") String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldPathVariable() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
