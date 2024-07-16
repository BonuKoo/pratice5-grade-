package com.example.pratice5_grademanagement_.domain.student.repository;

import com.example.pratice5_grademanagement_.domain.student.Student;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentScoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, StudentScoreId> {

    //Student와 Score id값이 일치하는 것을 Student Table에서 left Join해서 DTO에 담는다. -> Student에서 id에 해당하는 값, 이름, 성별, join (한국어, 영어, 수학)
    @Query("SELECT new com.example.pratice5_grademanagement_.domain.student.dto.StudentScoreDto(s.id, s.sname, s.gender, sc.kor, sc.eng, sc.mat) " +
            "FROM Student s LEFT JOIN Score sc ON s.id = sc.id")
    List<StudentScoreDto> findAllStudentScores();

}
