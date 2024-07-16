package com.example.pratice5_grademanagement_.domain.score.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
public class ClassTotalScoresDTO {

    private String sclass;
    private Integer totalKorean;
    private Integer totalEnglish;
    private Integer totalMath;

}
