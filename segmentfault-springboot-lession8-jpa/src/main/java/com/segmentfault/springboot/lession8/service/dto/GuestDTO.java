package com.segmentfault.springboot.lession8.service.dto;

import com.segmentfault.springboot.lession8.web.vo.CarVO;
import com.segmentfault.springboot.lession8.web.vo.CreditCardVO;
import com.segmentfault.springboot.lession8.web.vo.StoreVO;

import java.util.List;

public class GuestDTO {

    private Long id;

    private String name;

    private CreditCardDTO creditCard;

    private List<CarDTO> cars;

    private List<StoreDTO> stores;

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

    public CreditCardDTO getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardDTO creditCard) {
        this.creditCard = creditCard;
    }

    public List<CarDTO> getCars() {
        return cars;
    }

    public void setCars(List<CarDTO> cars) {
        this.cars = cars;
    }

    public List<StoreDTO> getStores() {
        return stores;
    }

    public void setStores(List<StoreDTO> stores) {
        this.stores = stores;
    }
}
