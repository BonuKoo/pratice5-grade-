package com.example.pratice5_grademanagement_.domain.score.repository;

import com.example.pratice5_grademanagement_.domain.score.Score;
import com.example.pratice5_grademanagement_.domain.score.compositeKey.ScoreId;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, StudentScoreId> {

}
