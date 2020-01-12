package com.BookLib.Library.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Members extends Auditable {

    @Getter
    @Setter
    @NotNull
    private String name;

    @Getter
    @Setter
    @NotNull
    @Email
    private String email;

    @Getter
    @Setter
    @NotNull
    private String number;

    @Getter
    @Setter
    @NotNull
    private String password;

    @Getter
    @Setter
    @NotNull
    @URL
    private String profilePicURL;

    @Getter
    @Setter
    @OneToOne
    private Library library;

    @Getter
    @Setter
    @NotNull
    private Long moneyFunds;


    public void deductFunds(Long deductionAmount){
        this.moneyFunds = this.moneyFunds - deductionAmount;
    }


}
