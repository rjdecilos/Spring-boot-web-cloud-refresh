package study.rj.rest.webservices.restfulwebservices.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.rj.rest.webservices.restfulwebservices.helloworld.model.HelloWorldBean;

@RestController
public class HelloWorldController {

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
}
