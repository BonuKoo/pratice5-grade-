package com.example.pratice5_grademanagement_.domain.score.service;

import com.example.pratice5_grademanagement_.domain.student.Student;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import com.example.pratice5_grademanagement_.domain.score.Score;
import com.example.pratice5_grademanagement_.domain.score.dto.ScoreRegistForm;
import com.example.pratice5_grademanagement_.domain.score.repository.ScoreRepository;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentScoreDto;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentScoreListDTO;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentWithScores;
import com.example.pratice5_grademanagement_.domain.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

    public void saveScore(ScoreRegistForm form){
        StudentScoreId id = new StudentScoreId(
                form.getSyear(),
                form.getSclass(),
                form.getSno());

        Score score = new Score(
                id,
                form.getKor(),
                form.getEng(),
                form.getMat()
        );
        scoreRepository.save(score);
    }

    public List<StudentScoreDto> getAllStudentWithScores(){
        return studentRepository.findAllStudentScores();
    }

    public Integer getTotalKorScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getKor).sum();
    }

    public Integer getTotalEngScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getEng).sum();
    }

    public Integer getTotalMatScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getMat).sum();
    }

    public Double getAvgKorScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getKor).average().orElse(0.0);
    }

    public Double getAvgEngScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getEng).average().orElse(0.0);
    }

    public Double getAvgMatScore(List<StudentScoreDto> studentScores) {
        return studentScores.stream().mapToInt(StudentScoreDto::getMat).average().orElse(0.0);
    }

    //모든 총점
    public Integer getTotalScore(List<StudentScoreDto> studentsWithScores) {
        return studentsWithScores.stream()
                .mapToInt(StudentScoreDto::getTot)
                .sum();
    }
    //모든 평균
    public Double getAverageScore(List<StudentScoreDto> studentsWithScores) {
        return studentsWithScores.stream()
                .mapToDouble(StudentScoreDto::getAvg)
                .average()
                .orElse(0.0);
    }
    /*
    로직이 너무 어렵고
    쿼리가 많이 나가게 된다.

    public List<StudentWithScores> getAllStudentWithScores() {
        List<Student> students = studentRepository.findAll();
        List<Score> scores = scoreRepository.findAll();

        return students.stream()
                .map(student -> {
                    StudentScoreId id = student.getId();
                    Score score = scores.stream()
                            .filter(s -> s.getId().equals(id))
                            .findFirst()
                            .orElse(new Score(id, 0, 0, 0)); // default scores if none found

                    String compositeKey = id.getSyear() + "-" + id.getSclass() + "-" + id.getSno();
                    String sname = student.getSname();
                    String gender = student.getGender().equals("M") ? "남" : "여";
                    Integer kor = score.getKor();
                    Integer eng = score.getEng();
                    Integer mat = score.getMat();
                    Integer tot = kor + eng + mat;
                    Double avg = Math.round((tot / 3.0) * 100.0) / 100.0; // 평균을 소수점 둘째 자리까지

                    return new StudentWithScores(compositeKey, sname, gender, kor, eng, mat, tot, avg);
                })
                .toList();
    }
     */
}
