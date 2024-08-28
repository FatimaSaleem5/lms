package com.task2.lms.dto;

import com.task2.lms.entity.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    private int bookid;
    private String title;
    private String publisheddate;
    private String isbn;
    private Author author;
}
