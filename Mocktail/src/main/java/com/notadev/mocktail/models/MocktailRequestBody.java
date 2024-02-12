package com.notadev.mocktail.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MocktailRequestBody {

    private String url;

    private Object body;

}
