package com.practice.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
//@JsonIgnoreProperties(value={"value1", "value2"})
//The above annotation is similar to @JsonIgnore it will ignore the variables that we don't want in the response 
//@JsonIgnore and @JsonIgnoreProperties are part of static filtering
@JsonFilter("SomeBeanFilter")
//@JsonFilter annotation to implement Dynamic Filtering on specific rest endpoints
public class SomeBean {

    private String field1;
    private String field2;

    // JsonIgnore annotation is used if something we don't want to return in the
    // response
    //@JsonIgnore
    private String field3;

}
