package com.notadev.mocktail.controller;

import com.notadev.mocktail.models.MocktailRequestBody;
import com.notadev.mocktail.services.Bartender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MocktailController {

    @Autowired
    private Bartender bartender;

    @RequestMapping(value="/getIngredients", method = RequestMethod.POST, consumes = "application/json")
    public void mocktailMagic(@RequestBody MocktailRequestBody mocktailRequestBody) {
        bartender.prepareMocktail(mocktailRequestBody);
    }

    @RequestMapping(value = "/freshMocktail/**", method = RequestMethod.GET, produces = "application/json")
    public Object hereIsYourDrink(HttpServletRequest httpServletRequest) {
        String url = httpServletRequest.getRequestURI();
        return bartender.getMocktail(url);
    }

}
