package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface UserService {
    void save(User u);
    Page<User> findAll(String kw, Pageable pageable);
    User findById(Integer uid);
    void delete(User u);
    void deleteById(Integer uid);
}