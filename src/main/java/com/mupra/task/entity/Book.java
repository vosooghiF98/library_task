package com.mupra.task.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mupra.task.base.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book extends BaseEntity {
    String name;
    @JsonIgnoreProperties("books")
    @ManyToOne(cascade = CascadeType.ALL)
    Publisher publisher;
    @JsonIgnoreProperties("books")
    @ManyToOne(cascade = CascadeType.ALL)
    Writer writer;
    LocalDate printYear;
    Integer inventory;
}
