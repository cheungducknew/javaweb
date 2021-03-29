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
 * Servlet implementation class StatisticsServletServlet
 */
public class StatisticsServlet extends HttpServlet {
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String func = request.getParameter("func");

		try {	
                        if(func.equals("合计")){
                            ArrayList<nation_data> ndlist  = null; 
                            Nation_dataDao  ndDao = new Nation_dataDao();
                            ndlist = ndDao.findAll();                           //核心查找语句  
                            
                            long mpo =0,fpo=0;
                            for(int i=0;i<ndlist.size();i++){ 
                                mpo+=ndlist.get(i).getMale_Population();
                                fpo+=ndlist.get(i).getFemale_Population();     
                            }
                            
                            long sum = mpo+fpo;
                            nation_data nd = new nation_data();
                            nd.setNation("合计");
                            nd.setMale_Population(mpo);
                            nd.setFemale_Population(fpo);
                            nd.setMale_Proportion((double)mpo/sum*100);
                            nd.setFemale_Proportion((double)fpo/sum*100);
                            nd.setSex_ratio((double)mpo/fpo*100);

                            session.setAttribute("nation_data", nd);
                            response.sendRedirect(request.getContextPath() + "/statistics.jsp");    
                        }                             
                        
                } catch(Exception ee) {
                        ee.printStackTrace();
                }

	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}       

}
