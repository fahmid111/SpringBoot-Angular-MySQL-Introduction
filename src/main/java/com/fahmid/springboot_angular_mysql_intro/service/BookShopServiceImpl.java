package com.fahmid.springboot_angular_mysql_intro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fahmid.springboot_angular_mysql_intro.model.BookShop;
import com.fahmid.springboot_angular_mysql_intro.repository.BookShopRepository;

@Service
public class BookShopServiceImpl implements BookShopService {

    private final BookShopRepository bookShopRepository;

    public BookShopServiceImpl(BookShopRepository bookShopRepository) {
        this.bookShopRepository = bookShopRepository;
    }

    @Override
    public List<BookShop> getAllBookShops() {
        return bookShopRepository.findAll();
    }
    @Override
    public List<BookShop> getBookShopByShopName(String shopName){
        return bookShopRepository.findByShopNameContainsIgnoreCase(shopName);
    }

    @Override
    public BookShop getBookShopById(Long id) {
        return bookShopRepository.findById(id).orElse(null);
    }

    @Override
    public BookShop addNewBookShop(BookShop bookShop) {
        return bookShopRepository.save(bookShop);
    }

    @Override
    public BookShop updateBookShop(Long id, BookShop bookShop) {
        BookShop existingBookShop = bookShopRepository.findById(id).orElse(null);
        if (existingBookShop != null) {
            if(bookShop.getShopNumber() != null){
                existingBookShop.setShopNumber(bookShop.getShopNumber());
            }
            if(bookShop.getShopName() != null){
                existingBookShop.setShopName(bookShop.getShopName());
            }
            if(bookShop.getLocation() != null){
                existingBookShop.setLocation(bookShop.getLocation());
            }
            existingBookShop.setBooks(bookShop.getBooks());
            if(bookShop.getContactNumber() != null){
                existingBookShop.setContactNumber(bookShop.getContactNumber());
            }
            if(bookShop.getEmail() != null){
                existingBookShop.setEmail(bookShop.getEmail());
            }
            return bookShopRepository.save(existingBookShop);
        }
        return null;
    }

    @Override
    public void deleteBookShop(Long id) {
        bookShopRepository.deleteById(id);
    }
}