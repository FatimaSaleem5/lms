package com.task2.lms.repo;

import com.task2.lms.entity.Author;
import com.task2.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
}
