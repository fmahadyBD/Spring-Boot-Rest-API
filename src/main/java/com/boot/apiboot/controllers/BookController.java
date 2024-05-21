package com.boot.apiboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.apiboot.entities.Books;
import com.boot.apiboot.services.BookService;
import org.springframework.web.bind.annotation.RequestParam;


// @Controller // when don't use the REST controller
//We need Controller annotation for say to sping this is controller;

@RestController
public class BookController {

    @Autowired// it inject it's object
    private BookService bookService;



    //this is a handeler it return String type data;It return the view;
    // we need to mentioned the url to the spring and method type;
    //ResponseBody: it simply return the text;

    // @RequestMapping(value = "/books",method = RequestMethod.GET)// GetMapping is combined of them
    // @ResponseBody// rest controller don't need it

    @GetMapping("/books")
    // public String getBooks(){
    // public Books getBooks(){
    public List<Books> getBooks(){
        // now return the json(jection convetert it in to json) type data. So i need to return the class type data;

        // Books book = new Books();
        // book.setId(12);
        // book.setTitle("The full time of it");
        // book.setAuthor("x");
        // return book;


        return this.bookService.getAllbook();
    }
    



    @GetMapping("/books/{id}")
    public Books getbook(@PathVariable("id") int id){

        return bookService.getBookById(id);

    }
}
