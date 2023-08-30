package com.second.kurs.interfaces;

import com.second.kurs.repository.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
