package com.codegym.repository;

import com.codegym.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IPersonRepo extends PagingAndSortingRepository<Person, Long> {
    Person findByUsername(String userName);
}
