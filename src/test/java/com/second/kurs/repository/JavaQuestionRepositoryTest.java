package com.second.kurs.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.second.kurs.TestingConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionRepositoryTest {
    JavaQuestionRepository javaQuestionRepository = new JavaQuestionRepository();

    @Test
    @DisplayName("Проверяет добавление нового элемента в репозиторий add(Question question)")
    void add() {
        assertEquals(javaQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionRepository.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Проверяет удаление элемента с репозитория remove(Question question)")
    void remove() {
        assertEquals(javaQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionRepository.getAll(), QUESTION1_COLLECTION);
        assertEquals(javaQuestionRepository.remove(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertTrue(javaQuestionRepository.getAll().isEmpty());
    }

    @Test
    @DisplayName("Проверяет получение всего списка getAll()")
    void getAll() {
        assertEquals(javaQuestionRepository.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertEquals(javaQuestionRepository.add(QUESTION2_OBJECT), QUESTION2_OBJECT);
        assertEquals(javaQuestionRepository.getAll().size(), 2);
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION1_OBJECT));
        assertTrue(javaQuestionRepository.getAll().contains(QUESTION2_OBJECT));
    }
}