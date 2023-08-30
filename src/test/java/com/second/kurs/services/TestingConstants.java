package com.second.kurs.services;

import com.second.kurs.repository.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestingConstants {
    public static final String QUESTION1 = "Question1";
    public static final String QUESTION2 = "Question2";
    public static final String ANSWER1 = "Answer1";
    public static final String ANSWER2 = "Answer2";

    public static final Question QUESTION1_OBJECT = new Question(QUESTION1, ANSWER1);
    public static final Question QUESTION2_OBJECT = new Question(QUESTION2, ANSWER2);
    public static final Collection<Question> QUESTION1_COLLECTION = new HashSet<>(Set.of(QUESTION1_OBJECT));
    public static final Collection<Question> QUESTION2_COLLECTION = new HashSet<>(Set.of(QUESTION1_OBJECT, QUESTION2_OBJECT));
}
