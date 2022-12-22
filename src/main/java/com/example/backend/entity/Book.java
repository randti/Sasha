package com.example.backend.entity;

import javax.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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