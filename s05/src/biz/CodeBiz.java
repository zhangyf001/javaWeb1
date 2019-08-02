package biz;

import java.util.List;

import entity.Code;

public interface CodeBiz {
	public boolean add(Code code);
	public List<Code> query();
	public Code queryById(int id);
	//添加n条记录
	public boolean addMuch(int n);
}
