package com.mupra.task.service;

import com.mupra.task.base.service.BaseService;
import com.mupra.task.entity.Admin;
import com.mupra.task.entity.Book;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AdminService extends BaseService<Admin>, UserDetailsService {
    Admin signUp(String username, String password);

    int addBook(Book book);

    List<Book> loadBooks();
}