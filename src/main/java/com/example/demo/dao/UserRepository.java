package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.account like ?1 or u.name like ?1 or " +
            "u.mobile like ?1 or u.email like ?1")
    Page<User> findByKeyword(String kw, Pageable pageable);

    @Modifying
    @Query("update User u set u.password = ?1 where u.uid = ?2")
    void modifyPassword(String pwd, Integer uid);
}