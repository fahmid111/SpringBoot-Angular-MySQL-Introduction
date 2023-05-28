package com.fahmid.springboot_angular_mysql_intro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fahmid.springboot_angular_mysql_intro.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByTitleContainsIgnoreCase(String title);
}
