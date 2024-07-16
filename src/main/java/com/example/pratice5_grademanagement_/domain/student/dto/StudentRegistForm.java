package com.example.pratice5_grademanagement_.domain.student.dto;


import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor @NoArgsConstructor
public class StudentRegistForm {
    //학년
    private String syear;
    //반
    private String sclass;
    //번호
    private String sno;
    //이름
    private String sname;
    //생년월일
    private String birth;
    //성별
    private String gender;
    //전화1
    private String tel1;
    //전화2
    private String tel2;
    //전화3
    private String tel3;

}