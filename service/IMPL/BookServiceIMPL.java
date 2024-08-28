package com.task2.lms.service.IMPL;

import com.task2.lms.dto.AuthorDTO;
import com.task2.lms.dto.BookDTO;
import com.task2.lms.dto.BookSaveDTO;
import com.task2.lms.dto.BookUpdateDTO;
import com.task2.lms.entity.Author;
import com.task2.lms.entity.Book;
import com.task2.lms.repo.AuthorRepo;
import com.task2.lms.repo.BookRepo;
import com.task2.lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService{
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;


    @Override
    public String addBook(BookSaveDTO bookSaveDTO) {
        Book book = new Book(

                bookSaveDTO.getTitle(),
                bookSaveDTO.getPublisheddate(),
                bookSaveDTO.getIsbn(),
                authorRepo.getById(bookSaveDTO.getAuthor_id())
        );
        bookRepo.save(book);
        return book.getTitle();

    }

    @Override
    public List<Book> getAllBook() {
        List<Book> getBooks = bookRepo.findAll();
        return getBooks;
    }

    @Override
    public String updateBook(BookUpdateDTO bookUpdateDTO) {
        if (bookRepo.existsById(bookUpdateDTO.getBookid()))
        {
            Book book = bookRepo.getById(bookUpdateDTO.getBookid());
            book.setAuthor(authorRepo.getById(bookUpdateDTO.getAuthor_id()));
           bookRepo.save(book);
            return book.getTitle();
        }

else{
            return "Book ID not exist";
        }

    }

    @Override
    public String deleteBook(int id)
    {
        if(bookRepo.existsById(id))
        {
            bookRepo.deleteById(id);
            return "Id found";
        }
        else {
            return "Id not found";
        }

    }


}
