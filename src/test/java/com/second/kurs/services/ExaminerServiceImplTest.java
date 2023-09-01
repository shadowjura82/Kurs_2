package com.second.kurs.services;

import com.second.kurs.exceptions.ExceedAmountItemsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.second.kurs.TestingConstants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(javaQuestionService.getAll()).thenReturn(QUESTION1_COLLECTION);
        when(mathQuestionService.getAll()).thenReturn(QUESTION1_COLLECTION);
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION1_OBJECT);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION2_OBJECT);
        assertThrows(ExceedAmountItemsException.class, () -> examinerService.getQuestions(3));
        assertDoesNotThrow(() -> examinerService.getQuestions(2));
        assertEquals(examinerService.getQuestions(2).size(), 2);
        assertTrue(examinerService.getQuestions(2).contains(QUESTION1_OBJECT));
        assertTrue(examinerService.getQuestions(2).contains(QUESTION2_OBJECT));
    }
}