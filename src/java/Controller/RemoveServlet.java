package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Nation_dataDao;
import Model.nation_data;
import javax.servlet.http.Cookie;


/**
 * Servlet implementation class RemoveServlet
 */
public class RemoveServlet extends HttpServlet {
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String func = request.getParameter("func");
                String id = request.getParameter("id");

		try {	
                        if(func.equals("findAll")){
                            ArrayList<nation_data> ndlist  = null; 
                            Nation_dataDao  ndDao = new Nation_dataDao();
                            ndlist = ndDao.findAll();                           //核心查找语句                  
                            session.setAttribute("nation_data_list", ndlist);		
                            response.sendRedirect(request.getContextPath() + "/Remove.jsp");
                            
                        }
                        
                        if(func.equals("remove")){
                            Nation_dataDao  ndDao = new Nation_dataDao();
                            ndDao.delete(id);                                   //核心删除语句
                            
                            ArrayList<nation_data> ndlist  = null; 
                            ndlist = ndDao.findAll();                           //核心查找语句                  
                            session.setAttribute("nation_data_list", ndlist);
                            response.sendRedirect(request.getContextPath() + "/Remove.jsp");
                            
                        }
                        
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
        
}
