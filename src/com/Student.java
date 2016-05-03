package com;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
public class Student {

	public Student() {
		
	}
	
	public Student(String sid, String marks) {
		this.sid = sid;
		this.marks = marks;
	}

	private String sid;
	private String marks;
	
	
	public String getSid() {
		return sid;
	}
	@XmlElement
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getMarks() {
		return marks;
	}
	@XmlElement
	public void setMarks(String marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [sid=");
		builder.append(sid);
		builder.append(", marks=");
		builder.append(marks);
		builder.append("]");
		return builder.toString();
	}

	


}
