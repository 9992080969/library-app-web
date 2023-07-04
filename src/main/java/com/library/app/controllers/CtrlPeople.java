package com.library.app.controllers;

import com.library.app.dao.PersonDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * контроллер /people
 *
 * @author Alexey Voronov on 01.07.2023
 */
@Controller
@RequestMapping("/people")
@AllArgsConstructor
public class CtrlPeople {
    private final PersonDAO personDAO;
    /**
     * Получам всех людей из DAO и передаем на отображение в представление
     */
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    /**
     * Получаем одного человека по id из DAO и передаем на отображение в представление
     */
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }
}