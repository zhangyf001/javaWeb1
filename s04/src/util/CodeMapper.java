package util;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import entity.Code;
//查询Code  要用的对象
public class CodeMapper implements RowMapper<Code> {

	@Override
	public Code mapRow(ResultSet rs, int arg1) throws SQLException {
		//对应数据库中的字段
		Code code = new Code(rs.getInt("id"),rs.getString("type"),rs.getString("text"));
		return code;
	}

}
