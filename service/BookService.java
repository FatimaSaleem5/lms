package com.task2.lms.service;

import com.task2.lms.dto.BookDTO;
import com.task2.lms.dto.BookSaveDTO;
import com.task2.lms.dto.BookUpdateDTO;
import com.task2.lms.entity.Book;

import java.util.List;

public interface BookService {
    String addBook(BookSaveDTO bookSaveDTO);

    List<Book> getAllBook();

    String updateBook(BookUpdateDTO bookUpdateDTO);

    String deleteBook(int id);
}
