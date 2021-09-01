package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepo iBlogRepo;

    @Override
    public Iterable<Blog> findAll() {
        return iBlogRepo.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(long id) {
        return iBlogRepo.findById(id);
    }

    @Override
    public Blog save(Blog blog) {
        return iBlogRepo.save(blog);
    }

    @Override
    public void remove(long id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public void likes(long id) {

    }

    @Override
    public void dislikes(long id) {

    }

    @Override
    public void show(long id) {

    }
}
