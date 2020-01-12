package com.BookLib.Library.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.*;
@Entity
@Table(name = "library")
public class Library extends Auditable{

    @ManyToMany
    @Getter
    @Setter
    private List<Books> currentBooks = new ArrayList<>();

    @ManyToMany
    @Getter
    @Setter
    private List<Books> wishList = new ArrayList<>();;

    @ManyToMany
    @Getter
    @Setter
    private List<Books> favouriteBooks = new ArrayList<>();

    @OneToMany
    @Getter
    @Setter
    private Map<Books, DaysCount> daysRemaining;

}
