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
public class Writer extends BaseEntity {
    String name;
    LocalDate birthday;
    @OneToMany(mappedBy = "writer")
    List<Book> books;
}
