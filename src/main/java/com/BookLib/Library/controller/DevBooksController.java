package com.BookLib.Library.controller;


import com.BookLib.Library.model.Books;
import com.BookLib.Library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dev")
public class DevBooksController {

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("/books")
    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }


}
