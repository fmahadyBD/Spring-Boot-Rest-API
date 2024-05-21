package com.boot.apiboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.apiboot.entities.Books;
import com.boot.apiboot.services.BookService;


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
    // public List<Books> getBooks(){
        //use status


    public ResponseEntity<List<Books>> getBooks(){
        // now return the json(jection convetert it in to json) type data. So i need to return the class type data;

        // Books book = new Books();
        // book.setId(12);
        // book.setTitle("The full time of it");
        // book.setAuthor("x");
        // return book;

        List<Books> list= this.bookService.getAllbook();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
       


    }
    



    @GetMapping("/books/{id}")
    public ResponseEntity<Books> getbook(@PathVariable("id") int id){
        Books book=null;
        book=bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(book));

    }

    // create new record;

    @PostMapping("/books")
    public ResponseEntity<Books> addBook(@RequestBody Books books){

        try {
            Books b= this.bookService.create(books);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();        }

      

       

    }

    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int id){

        try {
            this.bookService.deleteBook(id);// it call the buisness logic by method
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    


    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Books> bookUpdate(@RequestBody Books books ,@PathVariable("bookId") int bookId ){


        try {
            
            this.bookService.bookUpdate(books,bookId);
            return ResponseEntity.ok().body(books);
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
