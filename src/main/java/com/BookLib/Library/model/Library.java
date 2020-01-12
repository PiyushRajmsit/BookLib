package com.BookLib.Library.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Entity
@Table(name = "library")
public class Library extends Auditable{

    @ManyToMany
    @Getter
    @Setter
    private List<Books> currentBooks;

    @ManyToMany
    @Getter
    @Setter
    private List<Books> wishList;

    @ManyToMany
    @Getter
    @Setter
    private List<Books> favouriteBooks;

    /*
    @Getter
    @Setter
    private Map<Books, Date> daysRemaining;
    */
}
