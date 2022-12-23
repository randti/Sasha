package com.example.backend;

import com.example.backend.entity.Book;
import com.example.backend.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class BackendApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Autowired
    private BookRepository bookRepository;
    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        ObjectMapper bMapper = new ObjectMapper();
        TypeReference<List<Book>> etypeReference = new TypeReference<List<Book>>(){};
        InputStream einputStream = TypeReference.class.getResourceAsStream("/json/books.json");
        try {
            List<Book> books = bMapper.readValue(einputStream,etypeReference);
            for (Book curr : books) {
                bookRepository.save(curr);
            }
        } catch (IOException e){
            System.out.println("Error connect base" + e.getMessage());
        }

    }

}
