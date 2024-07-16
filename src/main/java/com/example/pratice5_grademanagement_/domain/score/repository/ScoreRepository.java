package com.example.pratice5_grademanagement_.domain.score.repository;

import com.example.pratice5_grademanagement_.domain.score.Score;
import com.example.pratice5_grademanagement_.domain.score.compositeKey.ScoreId;
import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO;
import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalScoresDTO;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, StudentScoreId>,ScoreRepositoryCustom {

    /*
    @Query(value = "SELECT sclass, " +
            "SUM(kor) AS total_korean, " +
            "SUM(eng) AS total_english, " +
            "SUM(mat) AS total_math " +
            "From score " +
            "GROUP BY sclass" ,nativeQuery = true)
    List<Object[]> findTotalScoresByClassVer1();

    // SQL -> JPQL
    @Query("SELECT s.id.sclass, SUM(s.kor) AS total_korean, " +
            "SUM(s.eng) AS total_english, " +
            "SUM(s.mat) AS total_math " +
            "FROM Score s " +
            "GROUP BY s.id.sclass")
    List<Object[]> findTotalScoresByClassVer2();

     */
    //Object[] -> DTO
    /*


    @Query("SELECT new com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalScoresDTO(" +
            "s.id.sclass, " +
            "SUM(s.kor), " +
            "SUM(s.eng), " +
            "SUM(s.mat)) " +
            "FROM Score s " +
            "GROUP BY s.id.sclass")
    List<ClassTotalScoresDTO> findTotalScoresByClassVer3();
     */

    /*
    @Query("SELECT com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO(" +
            "s.id.sclass, " +
            "SUM(s.kor), " +
            "SUM(s.eng), " +
            "SUM(s.mat), " +
            "AVG(s.kor), " +
            "AVG(s.eng), " +
            "AVG(s.mat)) " +
            "FROM Score s " +
            "GROUP BY s.id.sclass")
     */

    /*
    @Query("SELECT new com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO(" +
       "s.id.sclass, " +
       "SUM(s.kor), " +
       "SUM(s.eng), " +
       "SUM(s.mat), " +
       "AVG(CAST(s.kor AS float)), " +
       "AVG(CAST(s.eng AS float)), " +
       "AVG(CAST(s.mat AS float))) " +
       "FROM Score s " +
       "GROUP BY s.id.sclass")
       오류 발생 -> QueryDsl

    List<ClassTotalAndAvgScoresDTO> findTotalScoresByClassVer4();
     */
}
