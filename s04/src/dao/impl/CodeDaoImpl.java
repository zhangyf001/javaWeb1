package dao.impl;

import dao.CodeDao;
import entity.Code;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;
import util.CodeMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
	
	public boolean add(Code code) {
		List<Object> params = new ArrayList<Object>();
		params.add(code.getId());
		params.add(code.getType());
		params.add(code.getText());
		return jdbc.update("insert into t_code values(?,?,?) ",params.toArray())>0;
	}


	public List<Code> query() {
		
		return jdbc.query("select id,type from t_code", new CodeMapper());
		
	}

	public Code queryById(int id) {
		
		return jdbc.queryForObject("select * from t_code where id=?", new Object[]{id},new CodeMapper());
	}

	@Override
	public List<Map<String, Object>> find(Object[] param) {
		String sql = "select sum(id) idsum from t_code where id!=?";
		
		return jdbc.queryForList(sql, param);
	}
	
	public List<Code> findCodes() {
		String sql="select * from t_code";
		final List<Code>list=new ArrayList<Code>();
		jdbc.query(sql, new RowCallbackHandler(){
			public void processRow(ResultSet rs) throws SQLException {
				Code student=new Code();
				student.setId(rs.getInt("id"));
				student.setType(rs.getString("type"));
				student.setText(rs.getString("text"));
				list.add(student);
			}
			
		});
		return list;
	}
}
