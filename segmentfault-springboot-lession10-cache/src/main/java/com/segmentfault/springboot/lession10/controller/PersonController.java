package com.segmentfault.springboot.lession10.controller;

import com.segmentfault.springboot.lession10.entity.Person;
import com.segmentfault.springboot.lession10.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;

/**
 * Created by lizhuquan on 2018/3/7.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CacheManager cacheManager;

    @PostMapping
    public void savePerson(@RequestBody Person person) {
        personRepository.savePerson(person);
    }

    @GetMapping("{personId}")
    public Person findPerson(@PathVariable Long personId) {
        Person person = personRepository.findPerson(personId);
        return person;
    }

    @DeleteMapping("{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personRepository.deletePerson(personId);
    }
}
