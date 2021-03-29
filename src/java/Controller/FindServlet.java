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
 * Servlet implementation class FindServlet
 */
public class FindServlet extends HttpServlet {
        
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session = request.getSession();
		String func = request.getParameter("func");
                
                String data = null;
                data = request.getParameter("data");   
                String catagory = null;
                catagory = (String)request.getParameter("catagory");

		try {			
			nation_data nd = JudgeAndFind(data,catagory);  //核心查找语句                  
				try {   
                                        session.setAttribute("nation_data", nd);
					if(func.equals("show")){//跳转页面的确定
                                            String s = null;
                                                if(catagory.equals("民族")) s="/FindNation.jsp";
                                                else if(catagory.equals("男性人口数"))  s="/FindMpop.jsp";
                                                else if(catagory.equals("男性人口比重(%)")) s="/FindMpro.jsp";
                                                else if(catagory.equals("女性人口数")) s="/FindFpop.jsp";
                                                else if(catagory.equals("女性人口比重(%)")) s="/FindFpro.jsp";
                                                else if(catagory.equals("男女性别比(%)")) s="/FindSr.jsp";
                                                else s="404.html";
						response.sendRedirect(request.getContextPath() + s);
					}
				} catch(Exception ee) {
					ee.printStackTrace();
				}

                                
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
        
        protected nation_data JudgeAndFind(String data, String catagory){  //由catagory判断数据类型并进行查找
            Nation_dataDao  ndDao = new Nation_dataDao();
            nation_data  nd_term = null;
            
            if(catagory.equals("民族")){//最好用equal而不是 ==
                
                nd_term = ndDao.findNation(data);
                
            }else if(catagory.equals("男性人口数")){
                
                long data_term= Long.valueOf(data);//搞不清原理，但这里能用Long.valueof， 不能用Long.parseLong
                nd_term = ndDao.findMpop(data_term);
                
            }else if(catagory.equals("男性人口比重(%)")){
                
                double data_term = Double.valueOf(data);
                nd_term = ndDao.findMpro(data_term);
                
            }else if(catagory.equals("女性人口数")){
                
                long data_term = Long.valueOf(data);
                nd_term = ndDao.findFpop(data_term);
                
            }else if(catagory.equals("女性人口比重(%)")){
                
                double data_term = Double.valueOf(data);
                nd_term = ndDao.findFpro(data_term);
                
            }else if(catagory.equals("男女性别比(%)")){
                
                double data_term = Double.valueOf(data);
                nd_term = ndDao.findSr(data_term);
                
            }
                   
            return nd_term;
        }

}
