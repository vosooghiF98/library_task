package com.mupra.task.entity;

import com.mupra.task.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Publisher extends BaseEntity {
    String name;
    LocalDate establishedYear;
    @OneToMany(mappedBy = "publisher")
    List<Book> books;
}
