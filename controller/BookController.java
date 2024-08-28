package com.task2.lms.controller;

import com.task2.lms.dto.*;
import com.task2.lms.entity.Book;
import com.task2.lms.repo.BookRepo;
import com.task2.lms.service.AuthorService;
import com.task2.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
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
@PutMapping (path ="/update")
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

    //Pagination
    @Autowired
    private BookRepo bookRepo;

    @GetMapping (path = "/pagewise")
    public ResponseEntity<Page<Book>> getBooks (@PageableDefault(page=0,size =3) Pageable pageable)
    {
        Page<Book> books = bookRepo.findAll(pageable);
        return ResponseEntity.ok(books);
    }

}
