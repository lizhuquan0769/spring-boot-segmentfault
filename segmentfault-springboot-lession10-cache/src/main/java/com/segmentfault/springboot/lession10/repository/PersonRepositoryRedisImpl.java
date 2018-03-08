package com.segmentfault.springboot.lession10.repository;

import com.segmentfault.springboot.lession10.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lizhuquan on 2018/3/7.
 */
@Repository
public class PersonRepositoryRedisImpl implements PersonRepository {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Person findPerson(Long id) {
        System.out.println("查找缓存id:" + id);
        return (Person) redisTemplate.opsForValue().get(id);
    }

    @Override
    public Person savePerson(Person person) {
        redisTemplate.opsForValue().set(person.getId(), person);
        return person;
    }

    @Override
    public boolean deletePerson(Long personId) {
        redisTemplate.delete(personId);
        return true;
    }


}
