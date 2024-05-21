package com.boot.apiboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.apiboot.entities.Books;


public interface BookRepository extends CrudRepository<Books,Integer>{

public Books findById(int id);    
} 