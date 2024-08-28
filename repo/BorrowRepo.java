package com.task2.lms.repo;

import com.task2.lms.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrower, Integer> {
}
