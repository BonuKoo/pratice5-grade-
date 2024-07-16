package com.example.pratice5_grademanagement_.domain.dept.compositeKey;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Embeddable
public class DeptId {

    private String syear;
    private String sclass;

}
