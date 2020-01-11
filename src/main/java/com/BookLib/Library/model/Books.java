package com.BookLib.Library.model;


import com.BookLib.Library.repository.Constants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "Books")
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

    @Getter
    @Setter
    private Date date;

    @Getter
    @Setter
    @NotNull
    private Long price;

}
