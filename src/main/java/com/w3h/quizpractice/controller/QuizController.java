package com.w3h.quizpractice.controller;

import com.w3h.quizpractice.entity.Quiz;
import com.w3h.quizpractice.repository.QuizRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller(value = "QuizController")
@RequestMapping(value="/quiz")
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

    @GetMapping(value = "/addQuiz")
    public String addQuiz(){
        return "/addQuiz";
    }

    @PostMapping(value = "/submitQuiz")
    public String submitQuiz(String quizQuestion, String quizAnswer){

        log.info("{}///{}",quizQuestion,quizAnswer);
        Quiz quiz = new Quiz();
        quiz.setQuestion(quizQuestion);
        quiz.setAnswer(quizAnswer);

        quizRepository.save(quiz);

        return "redirect:/quiz/listQuiz";
    }

    @RequestMapping(value = "/listQuiz")
    public String listQuiz(Model model){

        List<Quiz> list = new ArrayList<Quiz>();
        list = quizRepository.findAll();

        model.addAttribute("quizList",list);

        return "listQuiz";
    }

}
