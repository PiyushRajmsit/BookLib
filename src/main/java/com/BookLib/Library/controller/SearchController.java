package com.BookLib.Library.controller;

import com.BookLib.Library.model.Books;
import com.BookLib.Library.model.Genre;
import com.BookLib.Library.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController{

    @Autowired
    BooksRepository booksRepository;

    @GetMapping("book/{book-name}")
    public Books searchByBookName(@PathVariable(value = "book-name") String bookName){
        Books foundBooks = booksRepository.findByBookName(bookName);
        return foundBooks;
    }
    @GetMapping("publisher/{publisher-name}")
    public List<Books> searchByPublisherName(@PathVariable(value = "publisher-name") String publisher){
        List<Books> foundBooks = booksRepository.findByPublisher(publisher);
        return foundBooks;
    }

    @GetMapping("genre/{gid}")
    public List<Books> searchByGenre(@PathVariable(value = "gid") int genreid) {
        Genre genre = Genre.fromValue(genreid);
        List<Books> foundBooks = booksRepository.findByGenre(genre);
        return foundBooks;
    }

    @GetMapping("author/{aname}")
    public List<Books> searchByAuthorName(@PathVariable(value = "aname") String author){
        List<Books> foundBooks = booksRepository.findByAuthorName(author);
        return foundBooks;
    }


}
