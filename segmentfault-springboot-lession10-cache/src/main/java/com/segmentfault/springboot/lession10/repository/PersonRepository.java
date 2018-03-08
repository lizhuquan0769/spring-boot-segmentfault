package com.segmentfault.springboot.lession10.repository;

import com.segmentfault.springboot.lession10.entity.Person;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by lizhuquan on 2018/3/7.
 */
@NoRepositoryBean
public interface PersonRepository {

   @Cacheable(cacheManager = "simpleCacheManager", cacheNames = "persons")
   Person findPerson(Long personId);

   @CachePut(cacheManager = "simpleCacheManager", cacheNames = "persons", key = "#person.id")
   Person savePerson(Person person);

   @CacheEvict(cacheManager = "simpleCacheManager", cacheNames = "persons", key = "#personId")
   boolean deletePerson(Long personId);
}
