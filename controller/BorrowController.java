package com.task2.lms.controller;


import com.task2.lms.dto.BookSaveDTO;
import com.task2.lms.dto.BookUpdateDTO;
import com.task2.lms.dto.BorrowerSaveDTO;
import com.task2.lms.dto.BorrowerUpdateDTO;
import com.task2.lms.entity.Book;
import com.task2.lms.entity.Borrower;
import com.task2.lms.repo.BorrowRepo;
import com.task2.lms.service.BookService;
import com.task2.lms.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("api/borrow")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private BorrowRepo borrowRepo;

    @PostMapping(path ="/save")
    public String saveBorrow (@RequestBody BorrowerSaveDTO borrowerSaveDTO){
        String borrowBooks = borrowService.saveBorrow(borrowerSaveDTO);
        return "Borrower Successfully";
    }
    @GetMapping (path ="/getAllBorrow")
    public List<Borrower> getAllBorrows()
    {
        List<Borrower> allBorrow = borrowService.getAllBorrows();
        return allBorrow;
    }
    @PutMapping (path = "/update")
    public String updateBorrow(@RequestBody BorrowerUpdateDTO borrowerUpdateDTO)
    {
        String borrowname = borrowService.updateBorrow(borrowerUpdateDTO);
        return borrowname;
    }
    @DeleteMapping (path = "/delete/{id}")
    public String deleteBorrow(@PathVariable (value= "id") int id){
        String borrowername = borrowService.deleteBorrow(id);
        return "deleted";
    }

    @GetMapping("/currently-borrowed")
    public List<Borrower> getCurrentlyBorrowedBooks() {
        return borrowService.getCurrentlyBorrowedBooks();
    }

    @GetMapping( path = "/borrowers/{id}")
    public ResponseEntity<Borrower> getBorrowerById(@PathVariable (value = "id") int id)
    {
        return borrowRepo.findById(id).map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());
    }
//
}
