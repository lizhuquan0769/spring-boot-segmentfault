package com.segmentfault.springboot.lession8.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "jpa_cars")
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id")
    private Guest guest;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}
