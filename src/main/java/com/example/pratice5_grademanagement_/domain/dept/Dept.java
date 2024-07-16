package com.example.pratice5_grademanagement_.domain.dept;

import com.example.pratice5_grademanagement_.domain.dept.compositeKey.DeptId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_dept_01")
@Entity //교사
public class Dept {

    /*
    //학년
    @Id @Column(length = 1,nullable = false)
    private String syear;
    //반
    @Id @Column(length = 2,nullable = false)
    private String sclass;
     */

    @EmbeddedId
    private DeptId id;

    //이름
    @Column(length = 20)
    private String tname;
}
