package com.BookLib.Library.repository;

import com.BookLib.Library.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books,Long> {
}
