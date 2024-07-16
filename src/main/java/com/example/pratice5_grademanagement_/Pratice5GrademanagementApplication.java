package com.example.pratice5_grademanagement_;

import com.example.pratice5_grademanagement_.domain.dept.Dept;
import com.example.pratice5_grademanagement_.domain.dept.compositeKey.DeptId;
import com.example.pratice5_grademanagement_.domain.dept.repository.DeptRepository;
import com.example.pratice5_grademanagement_.domain.score.Score;
import com.example.pratice5_grademanagement_.domain.score.compositeKey.ScoreId;
import com.example.pratice5_grademanagement_.domain.score.repository.ScoreRepository;
import com.example.pratice5_grademanagement_.domain.student.Student;
import com.example.pratice5_grademanagement_.domain.student.compositeKey.StudentScoreId;
import com.example.pratice5_grademanagement_.domain.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Pratice5GrademanagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Pratice5GrademanagementApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	DeptRepository deptRepository;
	@Autowired
	ScoreRepository scoreRepository;
	@Override

	/*

	Service service;

	save (asdf)
	PointDto pointDto1 = new PointDto("이름","몰라");
	 */

	public void run(String... args) throws Exception {

		/*
		for (int i = 1; i < 9; i++) {
			Student student = new Student();
			student.setSyear(""+i);
			student.setSclass();
		}

		 */
		//학생 키


		StudentScoreId id1 = new StudentScoreId("1","01","01");
		StudentScoreId id2 = new StudentScoreId("1","01","02");
		StudentScoreId id3 = new StudentScoreId("1","01","03");
		StudentScoreId id4 = new StudentScoreId("1","02","01");
		StudentScoreId id5 = new StudentScoreId("1","02","02");
		StudentScoreId id6 = new StudentScoreId("1","02","03");
		StudentScoreId id7 = new StudentScoreId("1","03","01");
		StudentScoreId id8 = new StudentScoreId("1","03","02");
		StudentScoreId id9 = new StudentScoreId("1","03","03");
		//학생
		Student student1 = new Student(id1,"김학생","20020101","F","010","1234","1001");
		Student student2 = new Student(id2,"이학생","20020201","M","010","1234","1002");
		Student student3 = new Student(id3,"박학생","20020301","M","010","1234","1003");
		Student student4 = new Student(id4,"조학생","20020401","M","010","1234","1004");
		Student student5 = new Student(id5,"유학생","20020501","M","010","1234","1005");
		Student student6 = new Student(id6,"여학생","20020601","M","010","1234","1006");
		Student student7 = new Student(id7,"남학생","20020701","F","010","1234","1007");
		Student student8 = new Student(id8,"황학생","20020801","F","010","1234","1008");
		Student student9 = new Student(id9,"전학생","20020901","F","010","1234","1009");
		studentRepository.saveAll(Arrays.asList(student1,student2,student3,student4,student5,student6,student7,
				student8,student9
		));


		//교사
		DeptId deptId1 = new DeptId("1","01");
		DeptId deptId2 = new DeptId("1","02");
		DeptId deptId3 = new DeptId("1","03");

		Dept dept1 = new Dept(deptId1,"김교사");
		Dept dept2 = new Dept(deptId2,"이교사");
		Dept dept3 = new Dept(deptId3,"박교사");

		deptRepository.saveAll(Arrays.asList(dept1,dept2,dept3));

		Score score1 = new Score(id1,50,50,50);
		Score score2 = new Score(id2,60,40,100);
		Score score3 = new Score(id3,70,70,70);
		Score score4 = new Score(id4,80,80,80);
		Score score5 = new Score(id5,50,50,50);
		Score score6 = new Score(id6,40,90,80);
		Score score7 = new Score(id7,70,70,70);
		Score score8 = new Score(id8,80,60,90);
		Score score9 = new Score(id9,90,80,70);
		scoreRepository.saveAll(Arrays.asList(score1,score2,score3,score4,score5,score6,score7,
				score8,score9
		));
	}
}
