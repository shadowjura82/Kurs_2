package com.second.kurs.services;

import com.second.kurs.interfaces.QuestionRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;

import static com.second.kurs.TestingConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository questions;
    @InjectMocks
    private JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    @DisplayName("Тестирование метода add(Question question)")
    void add() {
        when(questions.add(QUESTION1_OBJECT)).thenReturn(QUESTION1_OBJECT);
        when(questions.getAll()).thenReturn(QUESTION1_COLLECTION);
        assertEquals(javaQuestionService.add(QUESTION1_OBJECT), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода add(String question, String answer)")
    void testAdd() {
        when(questions.add(QUESTION1_OBJECT)).thenReturn(QUESTION1_OBJECT);
        when(questions.getAll()).thenReturn(QUESTION1_COLLECTION);
        assertEquals(javaQuestionService.add(QUESTION1, ANSWER1), QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
    }

    @Test
    @DisplayName("Тестирование метода remove(Question question)")
    void remove() {
        when(questions.add(QUESTION1_OBJECT)).thenReturn(QUESTION1_OBJECT);
        when(questions.getAll()).thenReturn(QUESTION1_COLLECTION);
        when(questions.remove(QUESTION1_OBJECT)).thenReturn(QUESTION1_OBJECT);
        javaQuestionService.add(QUESTION1_OBJECT);
        assertIterableEquals(javaQuestionService.getAll(), QUESTION1_COLLECTION);
        assertEquals(javaQuestionService.remove(QUESTION1_OBJECT), QUESTION1_OBJECT);
        when(questions.getAll()).thenReturn(new HashSet<>());
        assertTrue(javaQuestionService.getAll().isEmpty());
    }

    @Test
    @DisplayName("Тестирование метода getAll()")
    void getAll() {
        when(questions.getAll()).thenReturn(QUESTION2_COLLECTION);
        assertEquals(javaQuestionService.getAll().size(), 2);
        assertTrue(javaQuestionService.getAll().contains(QUESTION1_OBJECT));
        assertTrue(javaQuestionService.getAll().contains(QUESTION2_OBJECT));
    }

    @Test
    @DisplayName("Тестирование метода getRandomQuestion()")
    void getRandomQuestion() {
        when(questions.getAll()).thenReturn(QUESTION3_COLLECTION);
        assertTrue(QUESTION3_COLLECTION.contains(javaQuestionService.getRandomQuestion()));
    }
}