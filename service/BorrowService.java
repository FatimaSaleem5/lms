package com.task2.lms.service;

import com.task2.lms.dto.BorrowerSaveDTO;
import com.task2.lms.dto.BorrowerUpdateDTO;
import com.task2.lms.entity.Borrower;

import java.util.List;

public interface BorrowService {
    String saveBorrow(BorrowerSaveDTO borrowerSaveDTO);

    List<Borrower> getAllBorrows();


    String updateBorrow(BorrowerUpdateDTO borrowerUpdateDTO);

    String deleteBorrow(int id);
}
