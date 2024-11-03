package com.example.springseminar5example2.repositories;

import com.example.springseminar5example2.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}