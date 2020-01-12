package com.BookLib.Library.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "dayscount")
public class DaysCount extends Auditable {

    @Getter
    @Setter
    @NotNull
    private int days;
}
