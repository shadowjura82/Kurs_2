package com.second.kurs.services;

import com.second.kurs.exceptions.ExceedAmountItemsException;
import com.second.kurs.interfaces.QuestionService;
import com.second.kurs.repository.Question;
import com.second.kurs.interfaces.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;

@Service
@Component
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    @Qualifier("javaQuestionService")
    private QuestionService javaQuestionService;
    @Autowired
    @Qualifier("mathQuestionService")
    private QuestionService mathQuestionService;

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size())
            throw new ExceedAmountItemsException("Количество вопросов превышает количество записей в базе");
        Random random = new Random();
        Collection<Question> selectedQuestions = new HashSet<>();

//        Этот вариант не могу покрыть тестами с использованием моков т.к. тут надо использовать реальную коллекцию.
//        По этому использую более упрощенный вариант. См.ниже

//        Question item;
//        int javaCount;
//        int mathCount;
//        int i = 0;
//        do {
//            javaCount = random.nextInt(amount);
//            mathCount = amount - javaCount;
//        } while (!(javaCount <= javaQuestionService.getAll().size() && mathCount <= mathQuestionService.getAll().size()));
//        while (i < javaCount) {
//            item = javaQuestionService.getRandomQuestion();
//            if (!selectedQuestions.contains(item)) {
//                selectedQuestions.add(item);
//                i++;
//            }
//        }
//        while (i < amount) {
//            item = mathQuestionService.getRandomQuestion();
//            if (!selectedQuestions.contains(item)) {
//                selectedQuestions.add(item);
//                i++;
//            }
//        }

        while (selectedQuestions.size() < amount) {
            if (random.nextBoolean()) {
                selectedQuestions.add(javaQuestionService.getRandomQuestion());
            } else {
                selectedQuestions.add(mathQuestionService.getRandomQuestion());
            }
        }
        return selectedQuestions;
    }
}