package com.example.pratice5_grademanagement_.domain.score.repository;

import com.example.pratice5_grademanagement_.domain.dept.QDept;
import com.example.pratice5_grademanagement_.domain.score.QScore;
import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public class ScoreRepositoryCustomImpl implements ScoreRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public ScoreRepositoryCustomImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<ClassTotalAndAvgScoresDTO> findTotalScoresByClassVer4() {

        QScore qScore = QScore.score;
        QDept qDept = QDept.dept;

        return queryFactory
                .select(Projections.constructor(
                        ClassTotalAndAvgScoresDTO.class,
                        qScore.id.syear,        //학년
                        qScore.id.sclass,       //반
                        qDept.tname,            //선생님
                        qScore.kor.sum(),       //국어총점
                        qScore.eng.sum(),       //영어총점
                        qScore.mat.sum(),       //수학총점
                        qScore.kor.avg(),       //국어평균
                        qScore.eng.avg(),       //영어평균
                        qScore.eng.avg()        //수학평균
                        ))
                .from(qScore)                   //Score Table로부터
                .join(qDept)
                .on(qDept.id.syear.eq(qScore.id.syear)  // Dept 테이블과 Score 테이블의 학년이 같고
                //.on(qDept.id.sclass.eq(qScore.id.sclass)
                .and(qDept.id.sclass.eq(qScore.id.sclass)) //Dept 테이블과 Score 테이블의 반이 같은 조건으로
                )
                .groupBy(qScore.id.sclass)                          //Score 테이블의 '반'을 기준으로 정렬
                .fetch();

    }
}
