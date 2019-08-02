package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import util.CodeMapper;
import dao.CodeDao;
import entity.Code;
@Repository
public class CodeDaoImpl implements CodeDao{
	@Resource
	private JdbcTemplate jdbc; 
	
	public JdbcTemplate getJdbc() {
		return jdbc;
	}

	public void setJdbc(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	//添加
	public boolean add(Code code) {
		
		return jdbc.update("insert into t_code values(?,?,?) ",code.getId(),code.getType(),code.getText())>0;
	
	}

	//查询
	public List<Code> query() {
		
		return jdbc.query("select * from t_code", new CodeMapper());
		
	}

	public Code queryById(int id) {
		
		return jdbc.queryForObject("select * from t_code where id=?", new Object[]{id},new CodeMapper());
	}


	
}
