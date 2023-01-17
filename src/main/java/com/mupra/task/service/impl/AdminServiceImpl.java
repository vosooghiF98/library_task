package com.mupra.task.service.impl;

import com.mupra.task.base.service.impl.BaseServiceImpl;
import com.mupra.task.entity.Admin;
import com.mupra.task.entity.Book;
import com.mupra.task.enums.Role;
import com.mupra.task.exception.BadFormatException;
import com.mupra.task.repository.AdminRepository;
import com.mupra.task.service.AdminService;
import com.mupra.task.service.BookService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminRepository> implements AdminService {
    private final BookService bookService;
    private final BCryptPasswordEncoder passwordEncoder;
    public AdminServiceImpl(AdminRepository repository, BookService bookService, BCryptPasswordEncoder passwordEncoder) {
        super(repository);
        this.bookService = bookService;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Admin signUp(String username, String password){
        Admin admin = Admin.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(Role.ROLE_ADMIN)
                .build();
        try {
            return saveOrUpdate(admin);
        }catch (ConstraintViolationException c){
            throw new BadFormatException("This username is already exist.");
        }
    }
    @Override
    public int addBook(Book book){
        bookService.saveOrUpdate(book);
        return 1;
    }
    @Override
    public List<Book> loadBooks(){
        return bookService.loadBooks();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> {
            throw new BadFormatException("Not Found Any user with this username.");
        });
    }
}