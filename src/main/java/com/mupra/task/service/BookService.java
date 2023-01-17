package com.mupra.task.service;

import com.mupra.task.base.service.BaseService;
import com.mupra.task.entity.Book;

import java.util.List;

public interface BookService extends BaseService<Book> {
    List<Book> loadBooks();
}