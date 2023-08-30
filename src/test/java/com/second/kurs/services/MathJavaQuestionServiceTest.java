package com.second.kurs.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.second.kurs.services.TestingConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class MathJavaQuestionServiceTest {

    private MathQuestionService mathQuestionService = new MathQuestionService();

    @Test
    @DisplayName("Тестирование метода add(Question question)")
    void add() {
        assertEquals(mathQuestionService.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(mathQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода add(String question, String answer)")
    void testAdd() {
        assertEquals(mathQuestionService.add(QUESTION1, ANSWER1), QUESTION1_OBJECT);
        assertIterableEquals(mathQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода remove(Question question)")
    void remove() {
        mathQuestionService.add(QUESTION1_OBJECT);
        assertIterableEquals(mathQuestionService.getAll(), QUESTION1_COLLECTION);
        assertEquals(mathQuestionService.remove(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertTrue(mathQuestionService.getAll().isEmpty());
    }

    @Test
    @DisplayName("Тестирование метода getAll()")
    void getAll() {
        mathQuestionService.add(QUESTION1_OBJECT);
        mathQuestionService.add(QUESTION2_OBJECT);
//        assertIterableEquals(javaQuestionService.getAll(), QUESTION2_COLLECTION); Не работает!!!
        assertEquals(mathQuestionService.getAll().size(), 2);
        assertTrue(mathQuestionService.getAll().contains(QUESTION1_OBJECT));
        assertTrue(mathQuestionService.getAll().contains(QUESTION2_OBJECT));
    }

    @Test
    @DisplayName("Тестирование метода getRandomQuestion()")
    void getRandomQuestion() {
        mathQuestionService.add(QUESTION1_OBJECT);
        mathQuestionService.add(QUESTION2_OBJECT);
        assertTrue(mathQuestionService.getAll().contains(mathQuestionService.getRandomQuestion()));
    }
}