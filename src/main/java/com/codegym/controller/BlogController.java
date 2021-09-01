package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class BlogController {
    @Autowired
    IBlogService iBlogService;

    @GetMapping("")
    public String index() {
        return "/index";
    }

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView admin() {
        ModelAndView modelAndView = new ModelAndView("/admin");
        modelAndView.addObject("list", iBlogService.findAll());
        return modelAndView;
    }


    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/admin");
        return modelAndView;
    }
//    @GetMapping("/create")
//    public ArrayList<Blog> showBlogs() {
//        return (ArrayList<Blog>) iBlogService.findAll();
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
//        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.CREATED);
//    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable long id) {
        iBlogService.remove(id);
        return new ModelAndView("redirect:/admin/admin");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("list", iBlogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return new ModelAndView("redirect:/admin/admin");
    }

}
