package com.example.pratice5_grademanagement_.domain.score.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ScoreRegistForm {
    //학년
    private String syear;
    //반
    private String sclass;
    //번호
    private String sno;
    //국어
    private Integer kor;
    //영어
    private Integer eng;
    //수학
    private Integer mat;


}
