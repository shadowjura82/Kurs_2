package com.second.kurs.interfaces;

import com.second.kurs.repository.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
