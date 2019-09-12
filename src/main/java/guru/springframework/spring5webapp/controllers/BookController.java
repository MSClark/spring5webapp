package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //marks this object as a spring bean managed by the IOC container and its a controller type component
public class BookController {

    private BookRepository bookRepository; //because bookrepo is imported spring will autowire the component in for us

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books") // will fire this method when this endpoint is hit
    public String getBooks(Model model){ //spring mvc will pass in instance of the model. model is a interface, but itll pass in an implementation

        model.addAttribute("books", bookRepository.findAll()); // add all the books from the book repo to the model object via hibernate

        return "books"; //return tymeleaf view named books
    }
}
