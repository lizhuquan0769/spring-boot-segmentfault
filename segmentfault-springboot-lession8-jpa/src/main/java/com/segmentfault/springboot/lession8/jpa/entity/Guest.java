package com.segmentfault.springboot.lession8.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jpa_guests")
@Access(AccessType.FIELD)
public class Guest {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 64)
    private String name;

    @OneToOne(mappedBy = "guest",
            cascade = {CascadeType.REMOVE, CascadeType.MERGE, CascadeType.DETACH},
            fetch = FetchType.LAZY)
    private CreditCard creditCard;

    @OneToMany(mappedBy = "guest",
            cascade = {CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    private List<Car> cars;

    @ManyToMany(mappedBy = "guests",
            cascade = {CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    @OrderBy(value = "id DESC")
    private List<Store> stores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
}
