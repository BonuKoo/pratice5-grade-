package com.example.pratice5_grademanagement_.domain.score.service;

import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO;
import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalScoresDTO;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    /*

        DB 부하를 줄이고, 서버에서 고생하기
        - 자바로 SQL Grouping 하려면?

     */
    public Map<String, Map<String,Integer>> getScoresByClass(){
        //score 테이블 다 찾아오기
        List<Score> scores = scoreRepository.findAll();
        //Key, Value
        Map<String,List<Score>> scoreByClass = new HashMap<>();
        
        //scores 배열 길이만큼 반복하고, 해당하는 값을 Score 객체에 담는다.
        //-> 반별 점수 리스트 생성
        for (Score score : scores){
            //score 객체에는 복합키 StudentScoreId 타입의 id가 정의되어있고, 그 값의 Sclass의 값을 가져온다.
            //'반' 정보를 가져올 수 있게 된다.
            String sclass = score.getId().getSclass();

            //위에 정의해두었던 HashMap에 만약 해당'반'을 포함하고 있지 않다면,
            /*
            if (!scoreByClass.containsKey(sclass)){
                scoreByClass.put(sclass,new ArrayList<>());
            }
            */
            scoreByClass.putIfAbsent(sclass,new ArrayList<>());
            scoreByClass.get(sclass).add(score);
        }

        //반 별 총점 계산
        Map<String, Map<String,Integer>> totalScoreByClass = new HashMap<>();
        for (Map.Entry<String,List<Score>> entry: scoreByClass.entrySet()){
            String classId = entry.getKey();
            List<Score> classScores = entry.getValue();

            int totalKor = 0;
            int totalEng = 0;
            int totalMat = 0;

            for (Score score : classScores){
                totalKor += score.getKor();
                totalEng += score.getEng();
                totalMat += score.getMat();
            }

            Map<String,Integer> totals = new HashMap<>();
            totals.put("korean", totalKor);
            totals.put("english", totalEng);
            totals.put("math", totalMat);

            totalScoreByClass.put(classId,totals);


        }

        return totalScoreByClass;
    }

    /*
        Ver2
        JPQL로 가져오기 - DTO 없이 순수 반환
        -> 변수에 값을 담고서, Map에 저장
     */

    /*
    public Map<String, Map<String, Integer>> getTotalScoresByClassVer2() {
        List<Object[]> results = scoreRepository.findTotalScoresByClassVer2();

        Map<String, Map<String, Integer>> totalScoresByClass = new HashMap<>();

        for (Object[] result : results) {
            String classId = (String) result[0];
            Integer totalKorean = ((Number) result[1]).intValue();
            Integer totalEnglish = ((Number) result[2]).intValue();
            Integer totalMath = ((Number) result[3]).intValue();

            Map<String, Integer> totals = new HashMap<>();
            totals.put("korean", totalKorean);
            totals.put("english", totalEnglish);
            totals.put("math", totalMath);

            totalScoresByClass.put(classId, totals);
        }

        return totalScoresByClass;
    }
     */
    /*
    public List<ClassTotalScoresDTO> getTotalScoresByClassVer3(){
        return scoreRepository.findTotalScoresByClassVer3();
    }

     */
    
    //최적화

    public List<ClassTotalAndAvgScoresDTO> findTotalScoresByClassVer4(){
        return scoreRepository.findTotalScoresByClassVer4();
    }


    /*
    
        총점, 평균 따로 구하기
    
     */

    
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
}
