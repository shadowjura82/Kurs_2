package com.second.kurs.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.second.kurs.TestingConstants.*;
import static com.second.kurs.TestingConstants.QUESTION2_OBJECT;
import static org.junit.jupiter.api.Assertions.*;

class MathQuestionRepositoryTest {
    MathQuestionRepository mathQuestionRepository = new MathQuestionRepository();

    @Test
    @DisplayName("Проверяет добавление нового элемента в репозиторий add(Question question)")
    void add() {
        assertEquals(mathQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(mathQuestionRepository.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Проверяет удаление элемента с репозитория remove(Question question)")
    void remove() {
        assertEquals(mathQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(mathQuestionRepository.getAll(), QUESTION1_COLLECTION);
        assertEquals(mathQuestionRepository.remove(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertTrue(mathQuestionRepository.getAll().isEmpty());
    }

    @Test
    @DisplayName("Проверяет получение всего списка getAll()")
    void getAll() {
        assertEquals(mathQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertEquals(mathQuestionRepository.add(QUESTION2_OBJECT), QUESTION2_OBJECT);
        assertEquals(mathQuestionRepository.getAll().size(), 2);
        assertTrue(mathQuestionRepository.getAll().contains(QUESTION1_OBJECT));
        assertTrue(mathQuestionRepository.getAll().contains(QUESTION2_OBJECT));
    }
}