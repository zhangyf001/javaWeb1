package action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import entity.User;
import biz.UserBiz;
@Controller
public class UserAction {
	@Resource
	private UserBiz userBiz;
	
	
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}


	public String add(){
		userBiz.add(new User(2,"cccc"));
		return "ok";
	}
}
