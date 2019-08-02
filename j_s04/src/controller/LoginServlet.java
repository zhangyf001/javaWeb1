package controller;

import dao.UserDao;
import po.User;
import util.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DbUtil dbUtil=new DbUtil();
	UserDao userDao=new UserDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	/**
	 * servlet 简单登录
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		
		Connection con=null;
		try {
			User user=new User(userName,password);
			con=dbUtil.getCon();
			User currentUser=userDao.login(con, user);
			if(currentUser==null){
				request.setAttribute("error", "用户名或密码错误");
				request.setAttribute("userName", userName);
				request.setAttribute("password", password);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				HttpSession session=request.getSession();//用户名密码正确保存在session中并显示在main.jsp页面
				session.setAttribute("currentUser", currentUser);
				response.sendRedirect("main.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
