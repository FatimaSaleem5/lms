package com.task2.lms.service;

import com.task2.lms.dto.AuthorDTO;
import com.task2.lms.dto.AuthorSaveDTO;
import com.task2.lms.dto.AuthorUpdateDTO;
import com.task2.lms.entity.Author;

import java.util.List;

public interface AuthorService {
    String addAuthor(AuthorSaveDTO authorSaveDTO);

    List<Author> getAllAuthor();

    String updateAuthor(AuthorUpdateDTO authorUpdateDTO);

    String deleteAuthor(int id);
}
