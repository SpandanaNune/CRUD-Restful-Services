package com;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.internal.txw2.annotation.XmlElement;


@XmlRootElement
public class GradeItem {

	public GradeItem() {}
	
	public List<Grading> getGrades() {
		return grades;
	}
	@XmlElement
	public void setGrades(List<Grading> grades) {
		this.grades = grades;
	}
	private List<Grading> grades;

}
