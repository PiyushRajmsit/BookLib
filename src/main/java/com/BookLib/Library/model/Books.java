package com.BookLib.Library.model;


import com.BookLib.Library.repository.Constants;
import lombok.Getter;
import lombok.Setter;

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
    @NotNull
    @Column(length = Constants.MAX_DESCRIPTION_LENGTH)
    private String description;

    @Getter
    @Setter
    private Date date;
}
