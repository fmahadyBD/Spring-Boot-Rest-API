package com.boot.apiboot.services;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.apiboot.dao.BookRepository;
import com.boot.apiboot.entities.Books;


// in here we need to write the business logics


@Component// it will say to spring container make object of it's
// @Service
public  class BookService {

    // create some data
//    private static List<Books> list= new ArrayList<>();

//    static{
//     list.add(new Books(1,"Mahady","xyz"));
//     list.add(new Books(2,"Hasan","xyz"));
//     list.add(new Books(3,"Fahim","xyz"));
//     list.add(new Books(4,"abc","xyz"));
//    }

   // this is the business logic


   private BookRepository repo;


   // get all book

   public List<Books> getAllbook(){
    List<Books> list=(List<Books>)this.repo.findAll();

    return list;

   }

   public Books getBookById(int id){

    // use stream api to finding the book( it's from the java 8;)
    Books book= null;

    try {
        // book=list.stream().filter(e->e.getId()==id).findFirst().get();
        book=this.repo.findById(id);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return book;

   
    //filter and use lamda function, if option need then don't use the findFirst

   
   }


   public Books create(Books b){

    Books result=repo.save(b);
    // list.add(b);

     return result;// it will return the book for show
   }
   public void deleteBook(int bookId){

    // list=list.stream().filter(book->book.getId()!=bookId).collect(Collectors.toList());
    //if match then skipped


    repo.deleteById(bookId);

   }
   public void bookUpdate(Books bookNew,int bookid){

    // list = list.stream().map(b->{
    //     if(b.getId()==bookid){
    //         b.setTitle(bookNew.getTitle());
    //         b.setAuthor(bookNew.getAuthor());
    //     }
    //     return b;
    // }).collect(Collectors.toList());


    bookNew.setId(bookid);
    repo.save(bookNew);

   }
    
}
