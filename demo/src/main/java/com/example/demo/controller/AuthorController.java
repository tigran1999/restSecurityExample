package com.example.demo.controller;


import com.example.demo.jwt.JwtTokenUtil;
import com.example.demo.model.Author;
import com.example.demo.model.JwtAuthenticationRequest;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;






    @GetMapping("/authors")
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();






    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable(name = "id") int id){

        return authorRepository.getOne(id);
    }
    @DeleteMapping("/authors/{id}")
    public void deleteAuthorById(@PathVariable(name = "id") int id){

        authorRepository.deleteById(id);
    }
    @PostMapping("/authors")
    public  void saveAuthor(@RequestBody Author author){
        authorRepository.save(author);
    }

}
