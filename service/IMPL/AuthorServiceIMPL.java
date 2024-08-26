package com.task2.lms.service.IMPL;

import com.task2.lms.dto.AuthorSaveDTO;
import com.task2.lms.entity.Author;
import com.task2.lms.repo.AuthorRepo;
import com.task2.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceIMPL implements AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public String addAuthor(AuthorSaveDTO authorSaveDTO) {
        Author author = new Author(
             authorSaveDTO.getName(),   authorSaveDTO.getBio()
        );
        authorRepo.save(author);
        return author.getName();

    }
}
