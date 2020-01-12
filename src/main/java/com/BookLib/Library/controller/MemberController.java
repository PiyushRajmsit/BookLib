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
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BooksRepository booksRepository;
/*
    @PostMapping("/add")
    public String createMember(@Valid @RequestBody Members member) throws Exception{

        Members mem = memberRepository.findByname(member.getEmail());

        if(mem == null){
            return "Member Already Exists";
        }
        member.setMoneyFunds(Constants.NEW_USER_MONEY_FUNDS);
        memberRepository.save(member);
        return "Member Created Successfully";
    }
*/

    @GetMapping("/view-current-books/{id}")
    public List<Books> viewCurrentBooks(@PathVariable(value = "id") Long id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        List<Books> booksList = member.getLibrary().getCurrentBooks();
        return booksList;
    }

    @GetMapping("/view-wish/{id}")
    public List<Books> viewWishListBooks(@PathVariable(value = "id") Long id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        Library lib=member.getLibrary();
        return lib.getWishList();
    }

    @GetMapping("/view-favourites/{id}")
    public List<Books> viewFavouriteBooks(@PathVariable(value = "id") Long id) throws Exception{
        Members member = memberRepository.findById(id).orElseThrow(Exception::new);
        Library lib=member.getLibrary();
        return lib.getFavouriteBooks();
    }

    @PutMapping("/add-book-wish/(mid}/{bid}")
    public String addBookWishList(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);

        members.getLibrary().getWishList().add(books);

        return "Book Successfully Added";
    }

    @PutMapping("/add-favourites/(mid}/{bid}")
    public String addFavourites(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);
        if(members.getLibrary().getCurrentBooks().contains(books)){
            members.getLibrary().getFavouriteBooks().add(books);
            return "Book Successfully Added";
        }
        return "You haven't Bought this Book or Book doesn't Exist";
    }

    @PutMapping("/buy-book/(mid}/{bid}")
    public String buyBook(@PathVariable(value = "mid")Long member,@PathVariable(value = "bid")Long bookId) throws Exception{

        Members members = memberRepository.findById(member).orElseThrow(Exception::new);
        Books books = booksRepository.findById(bookId).orElseThrow(Exception::new);
        if(members.getLibrary().getCurrentBooks().contains(books)){
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
