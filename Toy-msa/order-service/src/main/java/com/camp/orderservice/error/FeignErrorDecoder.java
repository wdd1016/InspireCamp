package com.camp.orderservice.error;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() != 200) {
            return new ResponseStatusException(HttpStatus.valueOf(response.status()), response.reason());
        }
        return null;
    }
}
