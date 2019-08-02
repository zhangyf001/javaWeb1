package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@Controller
public class HelloAction {
	@RequestMapping(value="/{a1}/{a2}/a")//多级路径	(从地址栏输入多级路径)http://localhost:8080/sc04/aaaa1/aaaa2/a.zyf		
	public String hello(@PathVariable("a1") String str1,@PathVariable("a2") String str2){
		System.out.println("a1"+str1);
		System.out.println("a2"+str2);
		return "welcome";
	}
	@RequestMapping(value="/a")//ServletAPI对象 它们依次放在各自的请求域中
	public String qingqiuyu(HttpServletRequest request,HttpSession session){
		ServletContext application =session.getServletContext();
		request.setAttribute("a1", "aaaaaa1");
		session.setAttribute("a2", "aaaaaa2");
		application.setAttribute("a3", "aaaaaa3");
		return "welcome";
	}
	@RequestMapping(value="/b")
	public String qingqiuyu2(HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.print("aaaaaaaaaaaarrr");
		out.print("bbbbbbbbbbbbbr");
		out.flush();
		out.close();
		return null;
	}
	//重定向到某个页面
	@RequestMapping(value="/r")
	public String redirect(){
		return "redirect:/index.jsp";
	}
	//重定向到某个方法  值传不了
	@RequestMapping(value="/ff")
	public String redirectToAction(HttpServletRequest request){
		request.setAttribute("b1", "bbbbbbb1");
		return "redirect:/gg.zyf";
	}
	@RequestMapping(value="/gg")
	public String redirectToAction2(HttpServletRequest request){
		System.out.println(request.getAttribute("b1"));//重定向过来的 获取不了值
		return "welcome";
	}
	
	//重定向到其他类的某个方法  值传不了
		@RequestMapping(value="/kk")
		public String other(HttpServletRequest request){
			request.setAttribute("b2", "bbbbbbb2");
			return "redirect:/hello2/a.zyf";
		}
	
	//转发到某个方法  值传的了
	@RequestMapping(value="/hh")
	public String zhuangfa(HttpServletRequest request){
		request.setAttribute("b1", "bbbbbbb1");
		return zhuangfa2(request);//转发到同一个类中的某个action可以直接return方法名
	}
	@RequestMapping(value="/jj")
	public String zhuangfa2(HttpServletRequest request){
		System.out.println(request.getAttribute("b1"));//转发过来的 可以获取到值
		return "welcome";
	}
	
	//转发到其他类的某个方法   值可以传的了
	@RequestMapping(value="/ll")
	public String other2(HttpServletRequest request){
		request.setAttribute("b2", "bbbbbbb2");
		return "forward:/hello2/a.zyf";
	}
}
