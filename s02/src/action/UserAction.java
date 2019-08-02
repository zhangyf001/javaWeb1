package action;

import biz.UserBiz;
import entity.Role;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class UserAction {
	@Autowired
	private UserBiz userBiz;
	
	@Autowired(required = false)
	private Role role;
	
	
	public Role getRole() {
		return role;
	}
	@Autowired
	public void setRole(Role role) {
		this.role = role;
	}
	public UserBiz getUserBiz() {
		return userBiz;
	}
	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}


	public String add(){
		System.out.println("action层");
		userBiz.add(new User(2,"cccc"));
		return "ok";
	}
}
