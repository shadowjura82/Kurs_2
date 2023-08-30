package com.second.kurs.controllers;

import com.second.kurs.interfaces.ExaminerService;
import com.second.kurs.repository.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {
    @Autowired
    private ExaminerService examinerService;

    @GetMapping(path = "/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(name = "amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}