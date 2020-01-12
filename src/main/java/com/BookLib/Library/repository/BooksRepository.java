package com.BookLib.Library.repository;

import com.BookLib.Library.model.Books;
import com.BookLib.Library.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BooksRepository extends JpaRepository<Books,Long> {
    Books findByBookName(String bookName);
    List<Books> findByPublisher(String publisher);
    List<Books> findByGenre(Genre genre);
    List<Books> findByAuthorName(String  authorName);

}
