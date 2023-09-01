package com.second.kurs.services;

import com.second.kurs.interfaces.QuestionRepository;
import com.second.kurs.interfaces.QuestionService;
import com.second.kurs.repository.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class JavaQuestionService implements QuestionService {
    @Autowired
    @Qualifier("javaQuestionRepository")
    private QuestionRepository questions;

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        this.questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        this.questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        this.questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return this.questions.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> listOfQuestions = new ArrayList<>(this.questions.getAll());
        return listOfQuestions.get(random.nextInt(listOfQuestions.size()));
    }
}
