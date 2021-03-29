package Controller;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import Dao.Nation_dataDao;
import Dao.UserDao;
import Model.nation_data;
import Model.user;

 
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String identity = request.getParameter("identity");
		
		System.out.println(username + " " + password + " " + identity);
                
		if(username != null && password != null){
                    System.out.println("账号密码不为空");
                    if(identity !=null) {
                            if(identity.equals("admin")){		//管理员
                                    try{
                                            System.out.println("管理员登陆");
                                            UserDao uDao = new UserDao();
                                            user u = uDao.find(username); 
                                            if (u != null){
                                                    if (u.getPassword().equals(password)) {
                                                            if(u.getIdentity().equals(identity)){
                                                                System.out.println("ok");
                                                                func(username, password, 1, request, response);
                                                            }else{
                                                                request.setAttribute("errerMsg", "抱歉，您为普通用户！");
                                                                request.getRequestDispatcher("/Login.jsp").forward(request, response);
                                                            }
                                                    }else{
                                                        request.setAttribute("errerMsg", "密码错误！");
                                                        request.getRequestDispatcher("/Login.jsp").forward(request, response);
                                                    }
                                            } else {
                                                    request.setAttribute("errerMsg", "没有该管理员！");
                                                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                                            }
                                    } catch (Exception ee) {
                                            ee.printStackTrace();
                                    }
                            } else if (identity.equals("normal")){			//学生
                                    try{
                                            System.out.println("普通用户登陆");
                                            UserDao uDao = new UserDao();
                                            user u = uDao.find(username); 
                                            if (u != null) {
                                                    if (u.getPassword().equals(password)){
                                                            System.out.println("ok");
                                                            func(username, password, 0, request, response);	
                                                    }else{
                                                        request.setAttribute("errerMsg", "密码错误！");
                                                        request.getRequestDispatcher("/Login.jsp").forward(request, response);
                                                    }
                                                    
                                            } else {
                                                    request.setAttribute("errerMsg", "没有该普通用户！");
                                                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                                            }
                                    } catch (Exception ee) {
                                            ee.printStackTrace();
                                    }
                            }
                    } else {
                            //身份为空
                            request.setAttribute("errerMsg", "身份为空！");
                            request.getRequestDispatcher("/Login.jsp").forward(request, response);
                    }

		} else {
			//账号或密码为空
			request.setAttribute("errerMsg", "用户名或密码不能为空！");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}
	}
	
	private void func(String username, String password, int num,
			HttpServletRequest request, HttpServletResponse response) throws IOException{
		//将用户状态user对象存入session域
		user u = new user();
		u.setUsername(username);
		u.setPassword(password);
		if (num == 1) {
			u.setIdentity("admin");
			
		} else if (num ==0) {
			u.setIdentity("normal");
		}
		request.getSession().setAttribute("user", u);
                
		//登陆记录
		//UserDao userDao = new UserDao();
		//userDao.insert(u);

		if (num == 1) {			//管理员
			//跳转至首页
			response.sendRedirect(request.getContextPath() + "/Admin.jsp");
		} else if (num == 0){           //普通用户
			//跳转至首页
			response.sendRedirect(request.getContextPath() + "/Normal.jsp");
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
 
}
