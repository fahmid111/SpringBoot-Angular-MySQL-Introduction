package com.fahmid.springboot_angular_mysql_intro.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fahmid.springboot_angular_mysql_intro.model.BookShop;

@Repository
public interface BookShopRepository extends JpaRepository<BookShop, Long> {
    List<BookShop> findByShopNameContainsIgnoreCase(String shopName);
}