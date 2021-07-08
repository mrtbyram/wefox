package com.muratbayram.wefox.adapter.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "accounts")
public class AccountEntity {

    @Id
    private Long accountId;
    private String name;
    private String email;
    private Date birthdate;
    private Date lastPaymentDate;
    private Date cratedOn;


}
