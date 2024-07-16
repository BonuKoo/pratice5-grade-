package com.example.pratice5_grademanagement_.domain.student.dto;

import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class StudentScoreDto {

    private StudentScoreId id;
    private String sname;
    private String gender;
    private Integer kor;
    private Integer eng;
    private Integer mat;

    //학년-반-번호
    public String getS_ClassYearNo(){
        return id.getSyear() + "-" + id.getSclass() + "-" + id.getSno();
    }

    public Integer getTot(){
        return kor+eng+mat;
    }
    public Double getAvg(){
        return Math.round((getTot() / 3.0) * 100.0) / 100.0;
    }

}
