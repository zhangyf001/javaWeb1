package biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional//事物注解 这个方法里，要全部执行成功才成功，否则都不成功，即插入了n条记录都要成功才成功，
	public boolean addMuch(int n) {//只要有一条插入失败那么就回滚；若没这个注解 则插入失败时，之前插入成功的不会回滚
		int count=0;
		for(int i=0;i<n;i++){
			Code code = new Code(8+i,"type"+i,"text"+i);
			if(codeDao.add(code)){
				count++;
			}
		}
		return count==n;
	}
}
