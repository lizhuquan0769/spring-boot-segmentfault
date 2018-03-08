package com.segmentfault.springboot.lession12.controller;

import com.segmentfault.springboot.lession12.bean.Person;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by lizhuquan on 2018/3/8.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

    @PostMapping
    public Person addPerson(@RequestBody @Valid Person person
//            , BindingResult bindingResult
    ) {
        return person;
    }
}
