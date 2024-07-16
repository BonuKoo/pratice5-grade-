package com.example.pratice5_grademanagement_.domain.student.service;

import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import com.example.pratice5_grademanagement_.domain.student.Student;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentRegistForm;
import com.example.pratice5_grademanagement_.domain.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(StudentRegistForm form){

        StudentScoreId id = new StudentScoreId(
                form.getSyear(),
                form.getSclass(),
                form.getSno());

        Student student = new Student(
                id,
                form.getSname(),
                form.getBirth(),
                form.getGender(),
                form.getTel1(),
                form.getTel2(),
                form.getTel3()
        );
        studentRepository.save(student);
    }

}
