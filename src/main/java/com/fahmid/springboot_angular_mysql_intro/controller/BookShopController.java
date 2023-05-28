package com.fahmid.springboot_angular_mysql_intro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fahmid.springboot_angular_mysql_intro.model.BookShop;
import com.fahmid.springboot_angular_mysql_intro.service.BookShopService;

@RestController
@RequestMapping("/api")
public class BookShopController {

    private final BookShopService bookShopService;

    public BookShopController(BookShopService bookShopService) {
        this.bookShopService = bookShopService;
    }

    @GetMapping("/bookshops")
    public List<BookShop> getAllBookShops() {
        return bookShopService.getAllBookShops();
    }

    @PostMapping("/bookshops")
    public BookShop addNewBookShop(@RequestBody BookShop bookShop) {
        return bookShopService.addNewBookShop(bookShop);
    }

    @GetMapping("/bookshops/search/shopName")
    public List<BookShop> getBookShopByShopName(@RequestParam("shopName") String shopName) {
        return bookShopService.getBookShopByShopName(shopName);
    }

    @GetMapping("/bookshops/search/{id}")
    public BookShop getBookShopById(@PathVariable Long id) {
        return bookShopService.getBookShopById(id);
    }

    @PutMapping("/bookshops/search/{id}")
    public BookShop updateBookShop(@PathVariable Long id, @RequestBody BookShop bookShop) {
        return bookShopService.updateBookShop(id, bookShop);
    }

    @DeleteMapping("/bookshops/search/{id}")
    public void deleteBookShop(@PathVariable Long id) {
        bookShopService.deleteBookShop(id);
    }
}