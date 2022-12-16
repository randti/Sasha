package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Book {

    @Id
    private long id;

    @Column(name = "name", nullable = false)
    private String name;
    private String author;
    private long year;
    private long pages;
    private String publishing;
    private String link;

}