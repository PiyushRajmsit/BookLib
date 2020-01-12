package com.BookLib.Library.model;


import com.BookLib.Library.repository.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Books")
@JsonIgnoreProperties(value = {"date"},allowGetters = true)
public class Books extends Auditable{


    @Getter
    @Setter
    @NotNull
    private String bookName;


    @Getter
    @Setter
    @NotNull
    private String authorName;

    @Getter
    @Setter
    @NotNull
    private String publisher;

    @Getter
    @Setter
    @NotNull
    private String genre;

    @Getter
    @Setter
    @URL
    private String bookUrl;

    @Getter
    @Setter
    @NotNull
    @Column(length = Constants.MAX_DESCRIPTION_LENGTH)
    private String description;

    @Column(nullable = false,updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    @NotNull
    private Long price;


    @Getter
    @Setter
    @NotNull
    private BookStatus bookStatus = BookStatus.NOT_MY_BOOK;

}
