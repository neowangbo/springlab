/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.springlab.springmvc.web;

import com.martian.apps.springlab.springmvc.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author b5wang
 */
@Controller
@RequestMapping("/book")
public class BookController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(BookController.class);
    
    /**
     * URL template pattern with regular expression
     */
    @RequestMapping(path="/{name:[\\w\\s]*}+{author:[\\w\\s]*}+{language:[\\w]*}/find", method=RequestMethod.GET)
    public String find(@PathVariable String name, @PathVariable String author, @PathVariable String language, Model model){
        LOGGER.info("find a book by name {}, author: {}, language: {}", name, author, language);
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setLanguage(language);
        model.addAttribute("book", book);
        return "/jsp/viewBook.jsp";
    }
}
