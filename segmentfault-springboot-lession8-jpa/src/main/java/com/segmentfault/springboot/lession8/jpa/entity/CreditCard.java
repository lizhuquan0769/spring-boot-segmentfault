package com.segmentfault.springboot.lession8.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "jpa_credit_cards")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String cardNo;

    @Column
    private Date regDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
