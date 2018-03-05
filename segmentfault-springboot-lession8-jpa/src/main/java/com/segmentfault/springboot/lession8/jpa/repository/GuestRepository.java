package com.segmentfault.springboot.lession8.jpa.repository;

import com.segmentfault.springboot.lession8.jpa.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional(readOnly = false)
public class GuestRepository extends SimpleJpaRepository<Guest, Long> {

    @Autowired
    public GuestRepository(EntityManager entityManager) {
        super(Guest.class, entityManager);
    }
}
