package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import biz.AdminBiz;
import biz.impl.AdminBizImpl;
*/
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();
		
		String name=request.getParameter("aname");
		String pwd=request.getParameter("apwd");
		String yanzheng=request.getParameter("yanzheng");
		String rand=(String) session.getAttribute("rand");
		
		if(yanzheng==null || "".equals(yanzheng)){
			out.print("<script>alert('validCode is null!');history.go(-1);</script>");
			
		}else if(!yanzheng.equals(rand)){
			out.print("<script>alert('validCode is error!');history.go(-1);</script>");
		}else{
			/*AdminBiz biz=new AdminBizImpl();
			biz.register(name, pwd);*/
			out.print("<script>alert('success!');location='index.jsp';</script>");
		}
		
		
		
		

		out.flush();
		out.close();
	}

}
