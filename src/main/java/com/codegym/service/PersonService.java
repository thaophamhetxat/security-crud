package com.codegym.service;

import com.codegym.model.Person;
import com.codegym.repository.IPersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements UserDetailsService, IPersonService {
    @Autowired
    IPersonRepo iPersonRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Person persons = iPersonRepo.findByUsername(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(persons.getRole());
        UserDetails userDetails = new User(
                persons.getUsername(),
                persons.getPassword(),
                authorities
        );
        return userDetails;
    }


    @Override
    public Iterable<Person> findAllPerson() {
        return iPersonRepo.findAll();
    }

    @Override
    public Optional<Person> findByIdPerson(long id) {
        return iPersonRepo.findById(id);
    }

    @Override
    public Person savePerson(Person person) {
        return iPersonRepo.save(person);
    }

    @Override
    public void removePerson(long id) {
        iPersonRepo.deleteById(id);
    }
}
