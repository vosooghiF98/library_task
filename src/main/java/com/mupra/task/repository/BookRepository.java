package com.mupra.task.repository;

import com.mupra.task.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.scheduling.annotation.Scheduled;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Scheduled(cron = "0 0 8 * * *")
    @Modifying
    @Query("update Book b set b.inventory=10")
    void updateInventory();
}