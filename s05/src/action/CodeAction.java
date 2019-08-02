package action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import entity.Code;
import biz.CodeBiz;

@Controller
public class CodeAction {
	@Resource
	private CodeBiz codeBiz;

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
	 public void addMuch(int n){
		 if(codeBiz.addMuch(n)){
			 System.out.println("成功添加"+n+"条记录");
		 }else{
			 System.out.println("失败");
		 }
	 }
}
