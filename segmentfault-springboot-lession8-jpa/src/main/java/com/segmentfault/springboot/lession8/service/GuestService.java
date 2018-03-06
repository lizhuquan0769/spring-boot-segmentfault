package com.segmentfault.springboot.lession8.service;

import com.segmentfault.springboot.lession8.jpa.entity.Guest;
import com.segmentfault.springboot.lession8.jpa.repository.GuestRepository;
import com.segmentfault.springboot.lession8.service.dto.GuestDTO;
import com.segmentfault.springboot.lession8.web.vo.GuestVO;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public GuestDTO findById(Long id) {

        Guest guest = guestRepository.findOne(id);
        return dozerBeanMapper.map(guest, GuestDTO.class);
    }
}
