package com.practice.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * Static Filtering Controller Example.
 * @author govilrajput
 *
 */

@RestController
public class FilteringController {
    
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveSomeBean() {
	SomeBean someBean = new SomeBean("value1", "value2", "value3");
	SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");
	//Map the SomeBeanFilter on the SomeBean Class
	FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
	MappingJacksonValue mapping = new MappingJacksonValue(someBean);
	mapping.setFilters(filters);
	return mapping;
    }

}
