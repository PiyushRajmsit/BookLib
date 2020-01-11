package com.BookLib.Library.controller;

import com.BookLib.Library.model.Books;
import com.BookLib.Library.repository.AdminRepository;
import com.BookLib.Library.repository.BooksRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/dev")
public class AdminController {


    @Autowired
    BooksRepository bookRepository;
    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/add")
    public String addABook(@Valid @RequestBody Books book) throws Exception {

        Books bookfind = bookRepository.findBookName(book.getBookName());

        if (bookfind != null) {
            return "Book Already Exists";
        }
        bookRepository.save(book);
        return "book added Successfully";
    }


    @PostMapping("/update-price/{id}/{price}")
    public String updateBookPrice(@PathVariable(value = "id")Long bookid, @PathVariable(value = "price")Long bookprice)
            throws Exception
    {
        Books book = bookRepository.findById(bookid).orElseThrow(Exception::new);
        if(book == null) {
            return "Book is not present";
        }
        book.setPrice(bookprice);
        bookRepository.save(book);
        return "Book price updated successfully";
    }
}
