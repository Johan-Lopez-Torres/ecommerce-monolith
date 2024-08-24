package org.johan.microservices.sqljpaqueryes.utils;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Validator {
    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return bindingResult.getFieldErrors()
                    .stream()
                    .collect(
                            HashMap::new,
                            (map, fieldError) -> map.put(fieldError.getField(),
                                            fieldError.getDefaultMessage()),
                            Map::putAll
                    );
        }
        return Map.of();
    }
}
