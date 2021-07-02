package com.example.librarysystem.controller;

import com.example.librarysystem.model.Author;
import com.example.librarysystem.model.Book;
import com.example.librarysystem.model.Publisher;
import com.example.librarysystem.service.AuthorService;
import com.example.librarysystem.service.BookService;
import com.example.librarysystem.service.PublisherService;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")

public class BookController {
    final BookService bookService;
    final AuthorService authorService;
    final PublisherService publisherService;

    public BookController(BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }
    
    @GetMapping("/list")
    public String listBooks(Model theModel) {
        List<Book> theBooks = bookService.findAll();
        theModel.addAttribute("books", theBooks);
        return "list-books";
    }
    @GetMapping("/showFormForAdd")
    public String showFormForAdd(@ModelAttribute Book book, Model theModel) {
        //Book theBook = new Book();
        List<Author> theAuthors = authorService.findAll();
        List<Publisher> thePublishers = publisherService.findAll();

        //theModel.addAttribute("books", theBook);
        theModel.addAttribute("authors", theAuthors);
        theModel.addAttribute("publishers", thePublishers);
        
        return "book-form";
    }


    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("bookId") int theID, Model theModel) {
        List<Author> theAuthors = authorService.findAll();
        List<Publisher> thePublishers = publisherService.findAll();
        Book theBook = bookService.findById(theID);

        theModel.addAttribute("books", theBook);
        theModel.addAttribute("authors", theAuthors);
        theModel.addAttribute("publishers", thePublishers);
        return "bookupdate-form";
    }

  

    @PostMapping("/save")
    public String saveBook(@Validated @ModelAttribute Book book, @RequestParam("authorId")int authorId, @RequestParam("publisherId")int publisherId,BindingResult result) {
        if (result.hasErrors()) {
            return "book-form";
          }
        book.setAuthor(authorService.findById(authorId));
        book.setPublisher(publisherService.findById(publisherId));
        bookService.save(book);
        return "redirect:/books/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("bookId") int theId) {
        bookService.deleteById(theId);
        return "redirect:/books/list";
    }

    @GetMapping("/search")
    public String findBookByName(Model model, @Param("keyword") String keyword){
        model.addAttribute("books", bookService.findBookByName(keyword));
        return "list-books";
    }
}
