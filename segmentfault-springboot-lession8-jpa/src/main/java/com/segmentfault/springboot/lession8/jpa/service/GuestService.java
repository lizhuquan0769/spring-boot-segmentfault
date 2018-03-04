package com.segmentfault.springboot.lession8.jpa.service;

import com.segmentfault.springboot.lession8.jpa.entity.Guest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class GuestService {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(Guest guest) {
        entityManager.persist(guest);
    }

    public Guest findById(Long id) {
        return entityManager.find(Guest.class, id);
    }
}
