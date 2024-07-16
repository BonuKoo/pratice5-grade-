package com.example.pratice5_grademanagement_.domain.score;

import com.example.pratice5_grademanagement_.domain.score.compositeKey.ScoreId;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_score_01")
@Entity
public class Score {

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

    //Student와 Score 공통 PK를 갖고 있는 복합키
    @EmbeddedId
    private StudentScoreId id;

    //국어
    @Column(length = 3)
    private Integer kor;
    //영어
    @Column(length = 3)
    private Integer eng;
    //수학
    @Column(length = 3)
    private Integer mat;

}
