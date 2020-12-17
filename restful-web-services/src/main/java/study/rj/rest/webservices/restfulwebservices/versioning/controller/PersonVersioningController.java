package study.rj.rest.webservices.restfulwebservices.versioning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.rj.rest.webservices.restfulwebservices.versioning.model.PersonV1;
import study.rj.rest.webservices.restfulwebservices.versioning.model.PersonV2;

@RestController
@RequestMapping("/versioning")
public class PersonVersioningController {
    /**
     * Finalize versioning strategy when you start creating your API
     * */

    /**
     * Versioning using URI
     * factor to consider = URI pollution
     * */
    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2() {
        return new PersonV2("Bob", "Charlie");
    }


    /**
     * Versioning using param
     * factor to consider = URI pollution
     * */
    @GetMapping(path = "/person/param", params="version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/param", params="version=2")
    public PersonV2 paramV2() {
        return new PersonV2("Bob", "Charlie");
    }

    /**
     * Header versioning
     * Caching will be difficult due to header
     * Can't be executed using browser level
     * Difficult to Document
     * */

    @GetMapping(path = "/person/header", headers="X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers="X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2("Bob", "Charlie");
    }

    /**
     * Produces versioning
     * Caching will be difficult due to header
     * Can't be executed using browser level
     * Difficult to Document
     * */

    @GetMapping(path = "/person/produces", produces="application/vnd.company.app-v1+json")
    public PersonV1 producesV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2() {
        return new PersonV2("Bob", "Charlie");
    }

}
