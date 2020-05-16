package com.w3h.quizpractice.repository;

import com.w3h.quizpractice.entity.Example;
import com.w3h.quizpractice.entity.Quiz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.querydsl.QuerydslUtils;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class QuizRepositoryTest {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    ExampleRepository exampleRepository;

    @Test
    void test(){
        Quiz quiz = new  Quiz();
        quiz.setQuestion("혜미의 생일은?");
        quiz.setAnswer("8월1일");

        quizRepository.save(quiz);

        Example example = new Example();
        example.setQuizId(1);
        example.setText("9월2일");

        List<Example> list = new ArrayList<Example>();
        list.add(example);

        quiz.setExampleList(list);

        assertFalse(quizRepository.findAll().isEmpty());
    }

}