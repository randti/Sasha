package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<com.example.backend.entity.Book, Long> {

}
