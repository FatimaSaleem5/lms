package com.task2.lms.dto;

import com.task2.lms.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookSaveDTO {
    private String title;
    private String publisheddate;
    private String isbn;
    private int  author_id;
}
