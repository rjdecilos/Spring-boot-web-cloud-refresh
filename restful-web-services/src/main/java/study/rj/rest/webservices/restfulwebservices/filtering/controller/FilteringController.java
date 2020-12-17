package study.rj.rest.webservices.restfulwebservices.filtering.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.rj.rest.webservices.restfulwebservices.filtering.configuration.RestFiltering;
import study.rj.rest.webservices.restfulwebservices.filtering.model.SomeBean;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
public class FilteringController {

    /*
    * dynamic filtering below
    * */

    @GetMapping
    public MappingJacksonValue retrieveSomeBean() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");

        MappingJacksonValue mapping = RestFiltering
                .getMappingJacksonValue(someBean, "SomeBeanFilter", "field1", "field2");

        return mapping;
    }

    @GetMapping("/list")
    public MappingJacksonValue retrieveSomeBeanList() {
        List<SomeBean> someBeans = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value12", "value22", "value32"));

        MappingJacksonValue mapping = RestFiltering
                .getMappingJacksonValue(someBeans, "SomeBeanFilter", "field2", "field3");

        return mapping;
    }
}
