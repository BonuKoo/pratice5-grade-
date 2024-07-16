package com.example.pratice5_grademanagement_.domain.score.service;

import com.example.pratice5_grademanagement_.domain.score.Score;
import com.example.pratice5_grademanagement_.domain.score.repository.ScoreRepository;
import com.example.pratice5_grademanagement_.domain.student.Student;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentWithScores;
import com.example.pratice5_grademanagement_.domain.student.repository.StudentRepository;
import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ScoreServiceTest {

    private static final Logger log = LoggerFactory.getLogger(ScoreServiceTest.class);
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private ScoreService scoreService;

    @Test
    void getAllStudentWithScores(){

        //given
        List<Student> studentList = studentRepository.findAll();
        List<Score> scoreList = scoreRepository.findAll();

        //when
        /*
        List<StudentWithScores> list = studentList.stream()
                .map(student -> {
                    StudentScoreId id = student.getId();
                    Score score = scoreList.stream()
                            .filter(s -> s.getId().equals(id))
                            .findFirst()
                            .orElse(null);
                    return new StudentWithScores(student, score);
                })
                .toList();

        //then
        log.info("list:{} ",list.toString() );

         */
    }

}