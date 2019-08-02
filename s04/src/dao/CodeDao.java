package dao;

import entity.Code;

import java.util.List;
import java.util.Map;

public interface CodeDao {
	public boolean add(Code code);
	public  List<Code> query();
	public Code queryById(int id);
	public List<Map<String, Object>> find(Object[] param);
}
