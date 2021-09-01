package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {
    Iterable<Blog> findAll();
    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(long id);

    Blog save(Blog blog);

    void remove(long id);


    void likes(long id);
    void dislikes(long id);
    void show(long id);
}
