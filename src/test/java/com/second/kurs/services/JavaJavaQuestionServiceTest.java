package com.second.kurs.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.second.kurs.services.TestingConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;


class JavaJavaQuestionServiceTest {
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    @DisplayName("Тестирование метода add(Question question)")
    void add() {
        assertEquals(javaQuestionService.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода add(String question, String answer)")
    void testAdd() {
        assertEquals(javaQuestionService.add(QUESTION1, ANSWER1), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода remove(Question question)")
    void remove() {
        javaQuestionService.add(QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
        assertEquals(javaQuestionService.remove(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test
    @DisplayName("Тестирование метода getAll()")
    void getAll() {
        javaQuestionService.add(QUESTION1_OBJECT);
        javaQuestionService.add(QUESTION2_OBJECT);
//        assertIterableEquals(javaQuestionService.getAll(), QUESTION2_COLLECTION); Не работает!!!
        assertEquals(javaQuestionService.getAll().size(), 2);
        assertTrue(javaQuestionService.getAll().contains(QUESTION1_OBJECT));
        assertTrue(javaQuestionService.getAll().contains(QUESTION2_OBJECT));
    }

    @Test
    @DisplayName("Тестирование метода getRandomQuestion()")
    void getRandomQuestion() {
        javaQuestionService.add(QUESTION1_OBJECT);
        javaQuestionService.add(QUESTION2_OBJECT);
        assertTrue(javaQuestionService.getAll().contains(javaQuestionService.getRandomQuestion()));
    }
}