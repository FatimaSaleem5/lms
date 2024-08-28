package com.task2.lms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BorrowerUpdateDTO {
    private int borrow_id;
    private String email;
    private String name;
    private int book_id;
    private LocalDate borrowDate;
    private LocalDate returnDate;

}
