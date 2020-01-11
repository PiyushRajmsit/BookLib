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
    /*
    @PostMapping("add-book/{bname}/{aname}/{pname}/{gid}/{url}/")
    public String addbooks(@PathVariable(value = "bname") String bname,@PathVariable(value = "bname") String aname,
                                @PathVariable(value = "pname") String pname,@PathVariable(value = "bname")Long gid,
                                @PathVariable(value = "url")String url) throws Exception
    {

        return "Books Added";
    }
    */



}
