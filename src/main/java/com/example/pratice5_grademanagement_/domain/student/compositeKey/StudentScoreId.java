package com.example.pratice5_grademanagement_.domain.student.compositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class StudentScoreId {

    @Column(length = 1, nullable = false)
    private String syear;

    @Column(length = 2, nullable = false)
    private String sclass;

    @Column(length = 2, nullable = false)
    private String sno;
}
