package com.mupra.task.service.impl;

import com.mupra.task.base.service.impl.BaseServiceImpl;
import com.mupra.task.entity.Book;
import com.mupra.task.repository.BookRepository;
import com.mupra.task.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends BaseServiceImpl<Book, BookRepository> implements BookService {
    public BookServiceImpl(BookRepository repository) {
        super(repository);
    }

    @Override
    public List<Book> loadBooks() {
        return repository.findAll();
    }
}
