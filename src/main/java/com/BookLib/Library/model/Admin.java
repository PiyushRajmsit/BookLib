package com.BookLib.Library.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "admin")
public class Admin extends Auditable{

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @NotNull
    @Email
    private String email;


    @OneToMany
    @Getter
    @Setter
    private List<Books> booksList;
}
