package com;


import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import com.sun.xml.internal.txw2.annotation.XmlElement;

public class Grading {
	public Grading() {
	}
	private String gradetype;
	private List<Student> list;
	
	@XmlAttribute
	public String getGradetype() {
		return gradetype;
	}
	public void setGradetype(String gradetype) {
		this.gradetype = gradetype;
	}
	@XmlElement("student")
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}

	
}