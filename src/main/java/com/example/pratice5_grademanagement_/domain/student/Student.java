package com.example.pratice5_grademanagement_.domain.student;

import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Table(name = "tbl_student_01")
@Entity
public class Student {

    /*
    //학년
    @Id @Column(length = 1,nullable = false)
    private String syear;
    //반
    @Id @Column(length = 2,nullable = false)
    private String sclass;
    //번호
    @Id @Column(length = 2,nullable = false)
    private String sno;
    */
    @EmbeddedId
    private StudentScoreId id;

    //이름
    @Column(length = 20)
    private String sname;
    //생년월일
    @Column(length = 8)
    private String birth;
    //성별
    @Column(length = 1)
    private String gender;
    //전화1
    @Column(length = 3)
    private String tel1;
    //전화2
    @Column(length = 4)
    private String tel2;
    //전화3
    @Column(length = 4)
    private String tel3;


    public Student(StudentScoreId id, String sname, String birth, String gender, String tel1, String tel2, String tel3) {
        this.id = id;
        this.sname = sname;
        this.birth = birth;
        this.gender = gender;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
    }
}

/*
    Student를 기준으로, 복합키가 일치하는 자료를 Score에서 가져와서
    국어, 영어, 수학을 출력해야 한다.
 */