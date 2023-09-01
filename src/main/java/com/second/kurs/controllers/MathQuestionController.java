package com.second.kurs.controllers;

import com.second.kurs.interfaces.QuestionService;
import com.second.kurs.repository.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam/math")
public class MathQuestionController {
    @Autowired
    @Qualifier("mathQuestionService")
    private QuestionService mathQuestionService;

    @GetMapping
    public Collection<Question> getQuestions() {
        return mathQuestionService.getAll();
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return mathQuestionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        Question questionToDelete = new Question(question, answer);
        return mathQuestionService.remove(questionToDelete);
    }
}