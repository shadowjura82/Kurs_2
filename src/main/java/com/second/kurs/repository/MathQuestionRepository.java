package com.second.kurs.repository;

import com.second.kurs.interfaces.QuestionRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
@Component
public class MathQuestionRepository implements QuestionRepository {
    Set<Question> questions;

    public MathQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @PostConstruct
    private void init() {
        for (int i = 0; i < 10; i++) {
            Question entry = new Question("Math question " + i, "Math answer " + i);
            questions.add(entry);
        }
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
        return this.questions;
    }
}
