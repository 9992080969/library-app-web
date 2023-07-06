package com.library.app.controllers;

import com.library.app.dao.BookDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер /books
 *
 * @author Alexey Voronov on 01.07.2023
 */
@Controller
@RequestMapping("/books")
@AllArgsConstructor
public class CtrlBooks {
    private final BookDAO bookDAO;

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }
}