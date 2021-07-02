package com.example.librarysystem.controller;

import com.example.librarysystem.model.Author;
import com.example.librarysystem.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/author")
public class AuthorController {

    final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String listAuthors(Model theModel) {
        List<Author> theAuthors = authorService.findAll();
        theModel.addAttribute("authors", theAuthors);
        return "list-authors";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Author theAuthor = new Author();
        theModel.addAttribute("authors", theAuthor);
        return "author-form";
    }



    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("authorId") int theID, Model theModel) {
        Author theAuthor = authorService.findById(theID);
        theModel.addAttribute("authors", theAuthor);
        return "author-form";
    }
    @PostMapping("/save")
    public String saveAuthor(@Validated @ModelAttribute("authors") Author theAuthor, BindingResult result) {
        if (result.hasErrors()) {
            return "author-form";
          }
        authorService.save(theAuthor);
        return "redirect:/author/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("authorId") int theId) {
        authorService.deleteById(theId);
        return "redirect:/author/list";
    }
}
