package com.example.pratice5_grademanagement_.domain.score.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ClassTotalAndAvgScoresDTO {
    //학년
    private String syear;
    //반
    private String sclass;
    //교사명
    private String tname;
    //국어총점
    private Integer totalKorean;
    //영어총점
    private Integer totalEnglish;
    //수학총점
    private Integer totalMath;
    //국어평균
    private Double averageKorean;
    //영어평균
    private Double averageEnglish;
    //수학평균
    private Double averageMath;

}
