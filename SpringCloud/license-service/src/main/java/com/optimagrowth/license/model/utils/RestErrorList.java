package com.optimagrowth.license.model.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

import static java.util.Arrays.asList;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestErrorList {
    @JsonProperty("status")
    private HttpStatus status;

    @JsonProperty("errors")
    private ArrayList<ErrorMessage> errors;

    public RestErrorList(HttpStatus status, ErrorMessage... errors) {
        this.status = status;
        this.errors = new ArrayList<>(asList(errors));
    }
}
