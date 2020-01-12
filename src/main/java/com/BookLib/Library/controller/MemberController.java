package com.BookLib.Library.controller;


import com.BookLib.Library.model.*;
import com.BookLib.Library.repository.BooksRepository;
import com.BookLib.Library.repository.Constants;
import com.BookLib.Library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BooksRepository booksRepository;


    @GetMapping("/info")
    public String Testinfo() {
        return "Test Function";
    }

    @PutMapping("/add-book-wish/(mid}/{bid}")
    public String addBookWishList(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        System.out.println("HERE HERE");
        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);
        members.getLibrary().getWishList().add(books);
        return "Book Successfully Added";
    }

    @GetMapping("/viewcurrentbooks/{id}")
    public List<Books> viewCurrentBooks(@PathVariable(value = "id") Long id) throws Exception{
        System.out.println("HERE HERE");
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        if(member.getLibrary() == null)
        {
            return new ArrayList<Books>();
        }
        List<Books> booksList = member.getLibrary().getCurrentBooks();
        return booksList;
    }

    @GetMapping("/view-wish/{id}")
    public List<Books> viewWishListBooks(@PathVariable(value = "id") Long id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        Library lib=member.getLibrary();
        if(member.getLibrary() == null)
        {
            return new ArrayList<Books>();
        }

        return lib.getWishList();
    }

    @GetMapping("/view-favourites/{id}")
    public List<Books> viewFavouriteBooks(@PathVariable(value = "id") Long id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        Library lib=member.getLibrary();
        if(member.getLibrary() == null)
        {
            return new ArrayList<Books>();
        }
        return lib.getFavouriteBooks();
    }



    @PutMapping("/add-favourites/(mid}/{bid}")
    public String addFavourites(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);
        if(members.getLibrary() == null)
        {
            Library library = new Library();
            library.getCurrentBooks().add(books);
            members.setLibrary(library);
            return "Book Successfully Added";
        }

        if(members.getLibrary().getCurrentBooks().contains(books)){
            members.getLibrary().getFavouriteBooks().add(books);
            return "Book Successfully Added";
        }


        return "You haven't Bought this Book or Book doesn't Exist";
    }

    @PostMapping("/buy-book/(mid}/{bid}")
    public String buyBook(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);

        if(members.getLibrary() == null)
        {
            Library library = new Library();
            if(members.getMoneyFunds() >= books.getPrice())
            {
                members.deductFunds(books.getPrice());
                List<Books> new_book_list = new ArrayList<>();
                new_book_list.add(books);
                library.setCurrentBooks(new_book_list);
                members.setLibrary(library);
                DaysCount days = new DaysCount();
                days.setDays(Constants.REMAINING_DAYS_COUNT);
                library.getDaysRemaining().put(books,days);
                memberRepository.save(members);
                return "Book Successfully Added";
            }
            else{
                return "You don't have enough funds";
            }
        }


        else if(members.getLibrary().getCurrentBooks().contains(books)){
                    members.getLibrary().getFavouriteBooks().add(books);
                    return "You already Own this Book";
        }
        else if(members.getMoneyFunds() < books.getPrice() ){
            return "You don't have enough funds";
        }
        else
            {
            members.deductFunds(books.getPrice());
            DaysCount days = new DaysCount();
            days.setDays(Constants.REMAINING_DAYS_COUNT);
            members.getLibrary().getCurrentBooks().add(books);
            members.getLibrary().getDaysRemaining().put(books,days);
            memberRepository.save(members);
            return "Congrats Book has been Bought";
        }

    }

}
