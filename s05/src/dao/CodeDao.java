package dao;

import java.util.List;

import entity.Code;

public interface CodeDao {
	public boolean add(Code code);
	public  List<Code> query();
	public Code queryById(int id);
	
}
