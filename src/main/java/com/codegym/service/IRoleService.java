package com.codegym.service;

import com.codegym.model.Person;
import com.codegym.model.Role;

import java.util.Optional;

public interface IRoleService {
    Iterable<Role> findAllRole();
    Optional<Role> findByIdRole(long id);

    Role saveRole(Role role);

    void removeRole(long id);
}
