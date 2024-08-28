package com.task2.lms.dto;

import com.task2.lms.entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowerDTO {

    private int id;
    private String email;
    private String name;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
