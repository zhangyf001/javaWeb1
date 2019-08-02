package dao;

import entity.MyClass;

public interface ClassDao {
	public MyClass queryClassById(int id);
	public MyClass queryClassTeacherById(int id);
	public MyClass queryClassStudentById(int id);
	public MyClass queryClassTeacherStudentById(int id);
	
}
