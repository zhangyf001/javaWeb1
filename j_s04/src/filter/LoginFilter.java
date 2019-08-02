package filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//登录过滤  过滤器
public class LoginFilter implements Filter{
	public void destroy() {//当从Tomcat中移除这个项目时执行此方法
		System.out.println("destroy");

	}
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		//编码过滤
		servletRequest.setCharacterEncoding("utf-8");
		servletResponse.setContentType("text/html;charset=utf-8");
		servletResponse.setCharacterEncoding("utf-8");
		
		HttpServletRequest request=(HttpServletRequest)servletRequest;
		HttpSession session=request.getSession();
		Object object=session.getAttribute("currentUser");//从session中获取用户
		String path=request.getServletPath();
		if(object==null&&path.indexOf("login")<0){//如果session中没有用户且当前路径不是从登录页login.jsp进来则让他跳到登录页
			request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
		}else{
			//继续做原本访问网页的事情
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}
	//配置过滤器后 Tomcat启动 会先执行此方法
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");

	}
}
