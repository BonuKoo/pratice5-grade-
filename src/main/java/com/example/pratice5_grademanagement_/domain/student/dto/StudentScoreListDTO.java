package com.example.pratice5_grademanagement_.domain.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class StudentScoreListDTO {

    //학년-반-번호
    private String compositeKey;
    //이름
    private String sname;
    //성별
    private String gender;
    //국어
    private Integer kor;
    //영어
    private Integer eng;
    //수학
    private Integer mat;
    //총점
    private Integer tot;
    //평균
    private Double avg;
}
