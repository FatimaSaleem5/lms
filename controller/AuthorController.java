package com.task2.lms.controller;

import com.task2.lms.dto.AuthorDTO;
import com.task2.lms.dto.AuthorSaveDTO;
import com.task2.lms.dto.AuthorUpdateDTO;
import com.task2.lms.entity.Author;
import com.task2.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path ="/save")
    public String saveAuthor (@RequestBody AuthorSaveDTO authorSaveDTO){
        String authorname = authorService.addAuthor(authorSaveDTO);
        return "Added Successfully";

    }

    @GetMapping (path ="/getAllAuthor")
    public List<Author> getAllAuthor()
    {
        List<Author> allAuthors = authorService.getAllAuthor();
        return allAuthors;
    }

    @PutMapping (path = "/update")
    public String updateAuthor(@RequestBody AuthorUpdateDTO authorUpdateDTO)
    {
        String authorname = authorService.updateAuthor(authorUpdateDTO);
        return authorname;
    }

    @DeleteMapping (path = "/delete/{id}")
    public String deleteAuthor(@PathVariable (value= "id") int id){
        String authorname = authorService.deleteAuthor(id);
        return "deleted";
    }

}
