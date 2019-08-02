package biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CodeDao;
import entity.Code;
import biz.CodeBiz;
@Service
public class CodeBizImpl implements CodeBiz {
	@Resource
	private CodeDao codeDao;
	
	public CodeDao getCodeDao() {
		return codeDao;
	}

	public void setCodeDao(CodeDao codeDao) {
		this.codeDao = codeDao;
	}

	//添加
	public boolean add(Code code) {
		return codeDao.add(code);
	}

	//查询
	public List<Code> query() {
		return codeDao.query();
	}

	public Code queryById(int id) {
		Code code = null;
		try{
			 code = codeDao.queryById(id);
		}catch(Exception e){
			System.out.println("没有id="+id+"的这条记录");
		}
		
		return code;
	}

	@Override
	public List<Map<String, Object>> find(Object[] param) {
		List<Map<String, Object>> list = null;
		try{
			list = codeDao.find(param);
		System.out.println(list.get(0).get("idsum"));
		}catch(Exception e){
			System.out.println("无此条件的记录");
		}
		return list;
	}

}
