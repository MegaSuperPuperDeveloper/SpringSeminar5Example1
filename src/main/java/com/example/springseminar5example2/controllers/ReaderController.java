package com.example.springseminar5example2.controllers;

import com.example.springseminar5example2.models.Reader;
import com.example.springseminar5example2.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
@RequiredArgsConstructor
public class ReaderController {
    private final ReaderRepository readerRepository;

    @GetMapping
    public List<Reader> findAll() {
        return readerRepository.findAll();
    }

    @PostMapping
    public Reader save(@RequestBody Reader reader) {
        return readerRepository.save(reader);
    }
}