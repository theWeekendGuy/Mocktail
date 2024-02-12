package com.notadev.mocktail.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notadev.mocktail.models.MocktailRequestBody;
import com.notadev.mocktail.models.Mocktails;
import com.notadev.mocktail.repositories.MocktailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Bartender {

    @Autowired
    private MocktailRepository mocktailRepository;

        public void prepareMocktail(MocktailRequestBody mocktailRequestBody) {
            Mocktails mocktails = new Mocktails();
            mocktails.setUrl(mocktailRequestBody.getUrl());
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                String jsonString = objectMapper.writeValueAsString(mocktailRequestBody.getBody());
                mocktails.setExpectedResponse(jsonString);
                System.out.println("JsonString prepared: " + jsonString);
            } catch( Exception e){
                System.out.println("Exception occurred while parsing json object:" + e);
            }
            mocktailRepository.save(mocktails);
        }

        public Object getMocktail(String url) {
            // edit url and remove /freshMocktail/ from start
            url = url.substring(15);
            Mocktails mocktails= mocktailRepository.findByUrl(url);
            if(mocktails != null) {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    Object response = objectMapper.readValue(mocktails.getExpectedResponse(), Object.class);
                    return response;
                } catch (Exception e) {
                    System.out.println("Exception occurred while parsing json object:" + e);
                }
            } else{
                System.out.println("No mocktail found for url:" + url);
            }
            return "No mocktail found for given url, please create one first!";
        }
}
