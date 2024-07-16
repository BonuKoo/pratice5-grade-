package com.example.pratice5_grademanagement_.domain.dept.repository;

import com.example.pratice5_grademanagement_.domain.dept.Dept;
import com.example.pratice5_grademanagement_.domain.dept.compositeKey.DeptId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, DeptId> {


}
