package com.BookLib.Library.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Entity
@Table(name = "library")
public class Library extends Auditable{

    @Getter
    @Setter
    private List<Books> currentBooks;

    @Getter
    @Setter
    private List<Books> wishList;

    @Getter
    @Setter
    private List<Books> favouriteBooks;


    @Getter
    @Setter
    private Map<Books, Date> daysRemaining;

}
