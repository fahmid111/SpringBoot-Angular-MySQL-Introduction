package com.fahmid.springboot_angular_mysql_intro.service;


import java.util.List;

import com.fahmid.springboot_angular_mysql_intro.model.BookShop;

public interface BookShopService {
    List<BookShop> getAllBookShops();
    List<BookShop> getBookShopByShopName(String shopName);
    BookShop getBookShopById(Long id);
    BookShop addNewBookShop(BookShop bookShop);
    BookShop updateBookShop(Long id, BookShop bookShop);
    void deleteBookShop(Long id);
}