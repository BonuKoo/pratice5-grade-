package com.example.pratice5_grademanagement_.common.controller;

import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO;
import com.example.pratice5_grademanagement_.domain.score.dto.ScoreRegistForm;
import com.example.pratice5_grademanagement_.domain.score.service.ScoreService;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentRegistForm;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentScoreDto;
import com.example.pratice5_grademanagement_.domain.student.dto.StudentWithScores;
import com.example.pratice5_grademanagement_.domain.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {

    private final StudentService studentService;
    private final ScoreService scoreService;
    public MainController(StudentService studentService,ScoreService scoreService) {
        this.studentService = studentService;
        this.scoreService = scoreService;
    }

    //학생등록
    @GetMapping("/studentRegist")
    public String getStudentRegistForm(Model model){

        model.addAttribute("form",new StudentRegistForm());

        return "registStudent";
    }
    
    //학생등록 Post
    @PostMapping("studentRegist")
    public String  registStudent(StudentRegistForm form){
    studentService.saveStudent(form);
    return "index";
    }

    //성적입력
    @GetMapping("/scoreRegist")
    public String getScoreRegistForm(Model model){

        model.addAttribute("form",new ScoreRegistForm());

        return "registScore";
    }

    //성적입력 Post

    @PostMapping("/scoreRegist")
    public String saveScore(ScoreRegistForm form){
    scoreService.saveScore(form);
        return "index";
    }


    //성적조회
    @GetMapping("/score")
    public String getGrades(Model model) {

        //Student 테이블에서,
        //복합키가 일치하는 자료를 inner join해서
        //Score 로부터 국어,영어,수학을 가져와야 한다.
        List<StudentScoreDto> studentsWithScores = scoreService.getAllStudentWithScores();

        /*
            모든 총점, 모든 평균

        Integer totalScore = scoreService.getTotalScore(studentsWithScores);
        Double averageScore = scoreService.getAverageScore(studentsWithScores);
         */

        Integer totalKorScore = scoreService.getTotalKorScore(studentsWithScores);
        Integer totalEngScore = scoreService.getTotalEngScore(studentsWithScores);
        Integer totalMatScore = scoreService.getTotalMatScore(studentsWithScores);

        Double avgKorScore = scoreService.getAvgKorScore(studentsWithScores);
        Double avgEngScore = scoreService.getAvgEngScore(studentsWithScores);
        Double avgMatScore = scoreService.getAvgMatScore(studentsWithScores);

        model.addAttribute("studentsWithScores", studentsWithScores);

        model.addAttribute("totalKorScore", totalKorScore);
        model.addAttribute("totalEngScore", totalEngScore);
        model.addAttribute("totalMatScore", totalMatScore);

        model.addAttribute("avgKorScore", String.format("%.1f", avgKorScore));
        model.addAttribute("avgEngScore", String.format("%.1f", avgEngScore));
        model.addAttribute("avgMatScore", String.format("%.1f", avgMatScore));

        return "score";
    }

    /*

        '반' 별통계 ->
        학년,반,교사명,국어 총점, 영어 총점, 수학 총점, 국어 평균, 영어 평균, 수학 평균

     */

    //반별통계
    @GetMapping("/average")
    public String getAverage(Model model){

        List<ClassTotalAndAvgScoresDTO> totalAndAvgList = scoreService.findTotalScoresByClassVer4();
        model.addAttribute("list",totalAndAvgList);
        return "average";
    }


}
