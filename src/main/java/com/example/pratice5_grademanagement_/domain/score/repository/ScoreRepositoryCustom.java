package com.example.pratice5_grademanagement_.domain.score.repository;

import com.example.pratice5_grademanagement_.domain.score.dto.ClassTotalAndAvgScoresDTO;

import java.util.List;

public interface ScoreRepositoryCustom {

    List<ClassTotalAndAvgScoresDTO> findTotalScoresByClassVer4();

}
