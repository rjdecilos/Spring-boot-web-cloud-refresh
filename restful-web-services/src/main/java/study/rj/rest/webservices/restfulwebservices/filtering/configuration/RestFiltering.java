package study.rj.rest.webservices.restfulwebservices.filtering.configuration;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJacksonValue;

public class RestFiltering {

    public static MappingJacksonValue getMappingJacksonValue(Object Bean, String filterName, String ...args ) {

        MappingJacksonValue mapping = new MappingJacksonValue(Bean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept(args);

        FilterProvider filters = new SimpleFilterProvider()
                .addFilter(filterName, filter);

        mapping.setFilters(filters);

        return mapping;
    }
}
