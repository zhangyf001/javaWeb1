package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
	private String dbUrl="jdbc:oracle:thin:@localhost:1521:orcl";
	private String dbUserName="envir";
	private String dbPassword="1";
	private String jdbcName="oracle.jdbc.driver.OracleDriver";
	
	//连接
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	//关闭
	public void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	//连接测试
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("连接成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
