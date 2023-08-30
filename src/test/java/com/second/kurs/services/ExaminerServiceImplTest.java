package com.second.kurs.services;

import com.second.kurs.interfaces.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.second.kurs.services.TestingConstants.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        when(questionService.getAll()).thenReturn(QUESTION2_COLLECTION);
        when(questionService.getRandomQuestion()).thenReturn(QUESTION1_OBJECT);
//        assertThrows(ExceedAmountItemsException.class, () -> examinerService.getQuestions(3));
    }
}