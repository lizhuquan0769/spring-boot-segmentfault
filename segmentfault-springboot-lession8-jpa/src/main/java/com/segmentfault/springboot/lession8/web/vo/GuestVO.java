package com.segmentfault.springboot.lession8.web.vo;

import com.segmentfault.springboot.lession8.jpa.entity.Car;
import com.segmentfault.springboot.lession8.jpa.entity.Store;

import java.util.List;

public class GuestVO {

    private Long id;

    private String name;

    private CreditCardVO creditCard;

    private List<CarVO> cars;

    private List<StoreVO> stores;

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

    public CreditCardVO getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardVO creditCard) {
        this.creditCard = creditCard;
    }

    public List<CarVO> getCars() {
        return cars;
    }

    public void setCars(List<CarVO> cars) {
        this.cars = cars;
    }

    public List<StoreVO> getStores() {
        return stores;
    }

    public void setStores(List<StoreVO> stores) {
        this.stores = stores;
    }
}
