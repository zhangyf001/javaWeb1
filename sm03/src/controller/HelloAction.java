package controller;

import entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloAction {
	/***************************接收界面传来的值*************************************************/
	@RequestMapping(value="/a")		//将表单传过来的username重命名为name		
	public String hello(@RequestParam("uname") String name){/**这种方式如果从地址栏进来且地址栏不输入要传的参数会报错400 (可以设置required=false避免传入空参数时报错@RequestParam(value="uname",required=false )  String name)*/
		System.out.println("获取到的名字是"+name);
		return "welcome";
	}
	@RequestMapping(value="/b")		//uname变量与表单传过来的名字一样
	public String hello2(String uname){/**这种方式如果从地址栏进来且地址栏不输入要传的参数不会报错 */
		System.out.println("获取到的名字是"+uname);
		return "welcome";
	}
	
	@RequestMapping(value="/aa")			
	public String helloa(@RequestBody Student stu){
		System.out.println("获取到的ID是"+stu.getId());
		System.out.println("获取到的名字是"+stu.getName());
		System.out.println("分页参数"+stu.getPageParams().getStart()+","+stu.getPageParams().getLimit());
		return "welcome";
	}

	/**用map接收参数，表单里面的name值不变，form表单提交*/
	@RequestMapping("/queryList")
	public String queryEmployee(@RequestParam Map<String,Object> map,Model model) {
		String name = (String) map.get("employeeName");
		return null;
	}
	/***************************发送给界面的值*************************************************/
	@RequestMapping(value="/c")
	public ModelAndView hello3(){
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("s1",new Student(1,"张云"));
		map.put("idd", 100);
		map.put("stt", "abc");
		return new ModelAndView("welcome", map);
	}
	@RequestMapping(value="/d")
	public String hello4(Model model){
		model.addAttribute("s1",new Student(1,"张云锋"));
		model.addAttribute("idd", 100);
		model.addAttribute("stt", "abc");
		return "welcome";
	}
	
	/***************************接收并发送*************************************************/
	@RequestMapping(value="/e" ,method=RequestMethod.POST)//method默认是get
	public String hello5(Integer id,String name,Model mymap,Model mymap2){
		mymap.addAttribute("s1",new Student(id,name));
		mymap2.addAttribute("idd", 100);
		mymap2.addAttribute("stt", "abc");
		return "welcome";
	}
}
