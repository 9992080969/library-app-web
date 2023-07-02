package com.library.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * контроллер /people
 *
 * @author Alexey Voronov on 01.07.2023
 */
@Controller
public class CtrlPeople {
    @GetMapping("/people")
    public String linkPeople() {
        return "people/people";
    }
}