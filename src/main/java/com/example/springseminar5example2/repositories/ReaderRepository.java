package com.example.springseminar5example2.repositories;

import com.example.springseminar5example2.models.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}