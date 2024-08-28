package com.task2.lms.service.IMPL;

import com.task2.lms.dto.AuthorDTO;
import com.task2.lms.dto.AuthorSaveDTO;
import com.task2.lms.dto.AuthorUpdateDTO;
import com.task2.lms.entity.Author;
import com.task2.lms.repo.AuthorRepo;
import com.task2.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Author> getAllAuthor() {
        List<Author> getAuthors = authorRepo.findAll();
         return getAuthors;
    }

    @Override
    public String updateAuthor(AuthorUpdateDTO authorUpdateDTO)
    {
        if (authorRepo.existsById(authorUpdateDTO.getAuthorid())) {
            Author author = authorRepo.getById(authorUpdateDTO.getAuthorid());
            author.setName(authorUpdateDTO.getName());
            author.setBio(authorUpdateDTO.getBio());

            authorRepo.save(author);
            return author.getName();
        } else {
            System.out.println("Author id is not exist ");
        }
        return null;
    }

    @Override
    public String deleteAuthor(int id) {
        if(authorRepo.existsById(id))
        {
            authorRepo.deleteById(id);
        }
        else {
            System.out.println("Id not found");
        }
        return "";
    }
}
