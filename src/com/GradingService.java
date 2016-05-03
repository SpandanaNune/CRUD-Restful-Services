package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GradingService {

	GradingDao gradingDao;

	public GradingService() {
		gradingDao = GradingDao.instance;
	}

	public void createGradeItem(String gtype, String sid, String marks) {
		List<Grading> gradings = gradingDao.getGradeItems();
		Student student = new Student(sid,marks);
		boolean flag = true;
		for(Grading grade: gradings){
			if(grade.getGradetype().equalsIgnoreCase(gtype)){
				if(flag)flag = !flag;				
				grade.getList().add(student);
			}
		}
		if(flag){
			System.out.println("cmg here");
			Grading grade = new Grading();
			grade.setGradetype(gtype);
			List<Student> students = new ArrayList<Student>();
			students.add(student);
			grade.setList(students);
			gradings.add(grade);
		}
		System.out.println(gradings.size());
	}

	public List<Grading> getGrade(String gtype) {
		List<Grading> g=gradingDao.getGradeItems();
		List<Student> students = new ArrayList<Student>();
		for(Grading grade: g){
			if(grade.getGradetype().equalsIgnoreCase(gtype)){
				students.addAll(grade.getList());	
			}

		}
		List<Grading> l=new ArrayList<Grading>();
		Grading grade = new Grading();
		grade.setGradetype(gtype);
		grade.setList(students);
		l.add(grade);
		return l;

	}

	
	public List<Grading> getGradesList() {
		return gradingDao.getGradeItems();
	}

	public void deleteStudentGrade(String gtype, String sid) {
		List<Grading> gradings = gradingDao.getGradeItems();
		boolean flag = true;
		Iterator<Grading> grade = gradings.iterator();
		while(grade.hasNext()){
			Grading g=grade.next();
			if(g.getGradetype().equalsIgnoreCase(gtype)){
				Iterator<Student> st = g.getList().iterator();

				while(st.hasNext()){
					Student s=st.next();
					if(sid.equals(s.getSid())){
						if(flag)flag = !flag;			
						st.remove();

						if(g.getList().size()==0){
							grade.remove();
						}
					}
				}

			}
		}


	}
	public void updateStudentGrade(String gtype, String sid, String marks){
		List<Grading> gradings = gradingDao.getGradeItems();
		Student student = new Student(sid,marks);
		boolean flag = true;
		for(Grading grade: gradings){
			if(grade.getGradetype().equalsIgnoreCase(gtype)){
				for(Student st:grade.getList()){
					if(student.getSid().equals(st.getSid())){
						if(flag)flag = !flag;			
						st.setMarks(student.getMarks());
					}
				}

			}
		}
		if(flag){
			Grading grade = new Grading();
			grade.setGradetype(gtype);
			List<Student> students = new ArrayList<Student>();
			students.add(student);
			grade.setList(students);
			gradings.add(grade);
		}	
	}

}
