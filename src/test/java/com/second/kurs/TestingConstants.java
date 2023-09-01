package com.second.kurs;

import com.second.kurs.repository.Question;

import java.util.*;

public class TestingConstants {
    public static final String QUESTION1 = "Question1";
    public static final String QUESTION2 = "Question2";
    public static final String QUESTION3 = "Question3";
    public static final String ANSWER1 = "Answer1";
    public static final String ANSWER2 = "Answer2";
    public static final String ANSWER3 = "Answer3";
    public static final Question QUESTION1_OBJECT = new Question(QUESTION1, ANSWER1);
    public static final Question QUESTION2_OBJECT = new Question(QUESTION2, ANSWER2);
    public static final Question QUESTION3_OBJECT = new Question(QUESTION3, ANSWER3);
    public static final Collection<Question> QUESTION1_COLLECTION = new HashSet<>(Set.of(QUESTION1_OBJECT));
    public static final Collection<Question> QUESTION2_COLLECTION = new HashSet<>(Set.of(QUESTION1_OBJECT, QUESTION2_OBJECT));
    public static final Collection<Question> QUESTION3_COLLECTION = new HashSet<>(Set.of(QUESTION1_OBJECT, QUESTION2_OBJECT, QUESTION3_OBJECT));
}
