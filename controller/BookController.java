package com.task2.lms.controller;

import com.task2.lms.dto.*;
import com.task2.lms.entity.Book;
import com.task2.lms.service.AuthorService;
import com.task2.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path ="/save")
    public String saveBook (@RequestBody BookSaveDTO bookSaveDTO){
        String booktitle = bookService.addBook(bookSaveDTO);
        return "Added Successfully";

    }

    @GetMapping (path ="/getAllBooks")
    public List<Book> getAllBooks()
    {
        List<Book> allBook = bookService.getAllBook();
        return allBook;
    }
//
    @PutMapping (path = "/update")
    public String updateBook(@RequestBody BookUpdateDTO bookUpdateDTO)
    {
        String bookname = bookService.updateBook(bookUpdateDTO);
        return bookname;
    }
//
    @DeleteMapping (path = "/delete/{id}")
    public String deleteBook(@PathVariable (value= "id") int id){
        String bookname = bookService.deleteBook(id);
        return "deleted";
    }
}
