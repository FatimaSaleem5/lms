package com.task2.lms.controller;

import com.task2.lms.dto.AuthorSaveDTO;
import com.task2.lms.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping(path ="/save")
    public String saveAuthor (@RequestBody AuthorSaveDTO authorSaveDTO){
        String authorname = authorService.addAuthor(authorSaveDTO);
        return authorname;
    }


}
