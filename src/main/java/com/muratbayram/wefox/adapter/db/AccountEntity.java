package com.muratbayram.wefox.adapter.db;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    private Long id;
    private String name;
    private String email;
    private Date birthdate;
    private Date lastPaymentDate;
    private Date cratedOn;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
