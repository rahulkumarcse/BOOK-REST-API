package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class SimpleController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/books")
    public List<Book> getHi()
    {

        return bookService.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    public Book getBook(@PathVariable  int id)
    {

        return bookService.getBook(id);
    }

    @RequestMapping(method= RequestMethod.POST,value="/books")
    public void addBooks(@RequestBody Book books){
        bookService.addBook(books);
    }


    @RequestMapping(method= RequestMethod.PUT,value="/books/{id}")
    public void updateBooks(@RequestBody Book books,@PathVariable int id){
        bookService.updateBooks(books,id);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/books/{id}")
    public void deleteBooks(@PathVariable int id){
        bookService.deleteBooks(id);
    }


}
