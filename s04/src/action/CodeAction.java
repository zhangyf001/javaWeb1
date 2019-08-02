package action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import entity.Code;
import biz.CodeBiz;

@Controller
public class CodeAction {
	@Resource
	private CodeBiz codeBiz;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public CodeBiz getCodeBiz() {
		return codeBiz;
	}

	public void setCodeBiz(CodeBiz codeBiz) {
		this.codeBiz = codeBiz;
	}
	 public void add(Code code){
		  if(codeBiz.add(code)){
			  System.out.println("添加成功");
		  }else{
			  System.out.println("添加失败");
		  }
	 }
	 public void query(){
		List<Code>  codeList = codeBiz.query();
		for(Code e:codeList){
			System.out.println(e.toString());
		}
	 }
	 public void queryById(int id){
		Code code =  codeBiz.queryById(id);
		 System.out.println("id="+id+"的记录为："+code.toString());
	 }
	 public void find(Object[] param){
		 List<Map<String,Object>> list = codeBiz.find(param);
//		 for(Map<String,Object> e:list){
//			 System.out.println(e.get("id"));
//			 System.out.println(e.get("type"));
//		 }
	 }
	 //实验，不层层调用了。。。
	 
	 public void queryForInt(){
		 String sql = "select count(*) from t_code";
		 int count = jdbcTemplate.queryForInt(sql);
		 System.out.println(count); 
	 }
	 public void queryForObject(Object[] param){
		 String sql = "select type from t_code where id=?";
		 String type = jdbcTemplate.queryForObject(sql, param, String.class);
		 System.out.println(type);
	 }
	 public void insert(Object[]param){
		String SQL = "insert into t_code(id,type,text) values (?,?,?)";
		int num = jdbcTemplate.update( SQL, param);
		if(num>0) System.out.println("插入成功！");
	 }
}
