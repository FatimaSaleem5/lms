package com.task2.lms.service.IMPL;

import com.task2.lms.dto.BorrowerSaveDTO;
import com.task2.lms.dto.BorrowerUpdateDTO;
import com.task2.lms.entity.Book;
import com.task2.lms.entity.Borrower;
import com.task2.lms.repo.AuthorRepo;
import com.task2.lms.repo.BookRepo;
import com.task2.lms.repo.BorrowRepo;
import com.task2.lms.service.BookService;
import com.task2.lms.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceIMPL implements BorrowService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private BorrowRepo borrowRepo;


    @Override
    public String saveBorrow(BorrowerSaveDTO borrowerSaveDTO) {
        Borrower borrower = new Borrower(
                borrowerSaveDTO.getEmail(),
                borrowerSaveDTO.getName(),
                bookRepo.getById(borrowerSaveDTO.getBook_id()),
                borrowerSaveDTO.getBorrowDate(),
                borrowerSaveDTO.getReturnDate()
        );
        borrowRepo.save(borrower);
        return borrower.getEmail();

    }

    @Override
    public List<Borrower> getAllBorrows() {
        List<Borrower> getBorrows = borrowRepo.findAll();
        return getBorrows;
    }

    @Override
    public String updateBorrow(BorrowerUpdateDTO borrowerUpdateDTO) {
        if (borrowRepo.existsById(borrowerUpdateDTO.getBorrow_id()))
        {
            Borrower borrower = borrowRepo.getById(borrowerUpdateDTO.getBorrow_id());
            borrower.setEmail(borrowerUpdateDTO.getEmail());
            borrower.setName(borrowerUpdateDTO.getName());
            borrower.setBook(bookRepo.getById(borrowerUpdateDTO.getBook_id()));
            borrower.setBorrowDate(borrowerUpdateDTO.getBorrowDate());
            borrower.setReturnDate(borrowerUpdateDTO.getReturnDate());

            borrowRepo.save(borrower);
            return "Borrower Succesfully Updated";

        }

        else{
            return "Borrower ID not exist";
        }

    }

    @Override
    public String deleteBorrow(int id) {
        if(borrowRepo.existsById(id))
        {
            borrowRepo.deleteById(id);
            return "Id found";
        }
        else {
            return "Id not found";
        }
    }

    @Override
    public List<Borrower> getCurrentlyBorrowedBooks() {
        List<Borrower> getCurrentBorrower = borrowRepo.findByIsReturnedFalse();
        return getCurrentBorrower;
    }

}
