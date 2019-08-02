package biz;

import java.util.List;
import java.util.Map;

import entity.Code;

public interface CodeBiz {
	public boolean add(Code code);
	public List<Code> query();
	public Code queryById(int id);
	public List<Map<String, Object>> find(Object[] param);

}
