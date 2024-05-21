package com.boot.apiboot.services;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.boot.apiboot.entities.Books;


// in here we need to write the business logics


@Component// it will say to spring container make object of it's
// @Service
public  class BookService {

    // create some data
   private static List<Books> list= new ArrayList<>();

   static{
    list.add(new Books(1,"Mahady","xyz"));
    list.add(new Books(2,"Hasan","xyz"));
    list.add(new Books(3,"Fahim","xyz"));
    list.add(new Books(4,"abc","xyz"));
   }

   // this is the business logic

   // get all book

   public List<Books> getAllbook(){

    return list;

   }

   public Books getBookById(int id){

    // use stream api to finding the book( it's from the java 8;)
    Books book= null;

    book=list.stream().filter(e->e.getId()==id).findFirst().get();
    //filter and use lamda function, if option need then don't use the findFirst

    return book;
   }

    
}
