package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Person;

import java.util.Optional;

public interface IPersonService {
    Iterable<Person> findAllPerson();

    Optional<Person> findByIdPerson(long id);

    Person savePerson(Person person);

    void removePerson(long id);
}
