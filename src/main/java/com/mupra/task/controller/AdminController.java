package com.mupra.task.controller;

import com.mupra.task.dto.BookDto;
import com.mupra.task.dto.PublisherDto;
import com.mupra.task.dto.WriterDto;
import com.mupra.task.entity.Book;
import com.mupra.task.entity.Publisher;
import com.mupra.task.entity.Writer;
import com.mupra.task.mapper.PublisherMapper;
import com.mupra.task.mapper.WriterMapper;
import com.mupra.task.service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/add")
    public int addBook(@RequestBody BookDto bookDto, @RequestBody WriterDto writerDto, @RequestBody PublisherDto publisherDto){
        Writer writer = WriterMapper.INSTANCE.dtoToModel(writerDto);
        Publisher publisher = PublisherMapper.INSTANCE.dtoToModel(publisherDto);
        Book book = Book.builder()
                .name(bookDto.getName())
                .printYear(bookDto.getPrintYear())
                .inventory(bookDto.getInventory())
                .writer(writer)
                .publisher(publisher)
                .build();
        return adminService.addBook(book);
    }
    @GetMapping("/load")
    public List<Book> loadBooks(){
        return adminService.loadBooks();
    }
}
