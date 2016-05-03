package com;

import java.util.ArrayList;
import java.util.List;

public enum GradingDao {
	instance;

	private static List<Grading> grades = new ArrayList<Grading>();

	public List<Grading> getGradeItems() {
		return grades;
	}


}
