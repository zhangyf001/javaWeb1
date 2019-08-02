package entity;

import java.util.List;

public class MyClass {
	private int classId;
	private String className;
	private Teacher teacher;//多个班级对应一个老师
	private List<Student> studentList;//一个班级对应多个学生
	
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public String toString() {
		return "MyClass [classId=" + classId + ", className=" + className
				+ ", teacher=" + teacher + ", studentList=" + studentList + "]";
	}
	
	
}
