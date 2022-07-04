package com.ironhack.worldservice.controller.impl;

import com.ironhack.worldservice.controller.interfaces.WorldController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameControllerImpl implements NameController {
    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    public String name() {
        return "Lola";
    }
}
