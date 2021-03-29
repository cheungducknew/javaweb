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


/**
 * Servlet implementation class UpdateServlet
 */
public class UpdateServlet extends HttpServlet {
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String func = request.getParameter("func");
                String id = request.getParameter("id");
                
                String nation = request.getParameter("nation");
                String male_Population = request.getParameter("male_Population");
                String male_Proportion = request.getParameter("male_Proportion");
                String female_Population = request.getParameter("female_Population");
                String female_Proportion = request.getParameter("female_Proportion");
                String sex_ratio = request.getParameter("sex_ratio");
		try {	
                        if(func.equals("findAll")){
                            ArrayList<nation_data> ndlist  = null; 
                            Nation_dataDao  ndDao = new Nation_dataDao();
                            ndlist = ndDao.findAll();                           //核心查找语句                  
                            session.setAttribute("nation_data_list", ndlist);		
                            response.sendRedirect(request.getContextPath() + "/Update.jsp");
                        }
                        if(func.equals("update")){
                            nation_data nd = new nation_data();                            
                            nd.setNation(nation);
                            nd.setMale_Population(Long.valueOf(male_Population));
                            nd.setMale_Proportion(Double.valueOf(male_Proportion));
                            nd.setFemale_Population(Long.valueOf(female_Population));
                            nd.setFemale_Proportion(Double.valueOf(female_Proportion));
                            nd.setSex_ratio(Double.valueOf(sex_ratio));
                            
                            Nation_dataDao  ndDao = new Nation_dataDao();
                            ndDao.update(nd,id);                                           //核心修改语句
                            ArrayList<nation_data> ndlist  = null; 
                            ndlist = ndDao.findAll();                           //核心查找语句                  
                            session.setAttribute("nation_data_list", ndlist);
                            response.sendRedirect(request.getContextPath() + "/Update.jsp");
                            
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
