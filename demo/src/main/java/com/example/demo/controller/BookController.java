package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(name = "id") int id){

        return bookRepository.getOne(id);
    }
    @DeleteMapping("/books/{id}")
    public void deleteBookById(@PathVariable(name = "id") int id){

        bookRepository.deleteById(id);
    }
    @PostMapping("/books")
    public  void saveBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @GetMapping("/booksByAuthor/{id}")
    public List<Book> getBooksByAuthor(@PathVariable(name = "id") int id){

        return bookRepository.findAllByAuthor(authorRepository.getOne(id));
    }
}
