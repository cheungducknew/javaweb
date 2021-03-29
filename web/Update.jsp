<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.nation_data"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 使用bootstrap框架-->
    <!-- jquery.min.js first, then bootstrap.min.css, then bootstrap.min.js -->
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    
    <!--修改行js-->
    <script src="js/Update.js"  language="javascript"></script>
</head>

<body style=" background: rgba(255,255,255,0); background-size: single;text-align: center;">
    
    <div class="container" >
        <br>
        <h1> 修改数据操作页面</h1>
        <form role="form" name="form1" action="${pageContext.request.contextPath }/UpdateServlet" method = "get">
            <!--函数功能的input，hidden掉了-->
            <input name="func" type="hidden" value="findAll" >
            <button class="btn btn-info" type="button" onClick="form1.submit();" >显示最新数据</button> 
        </form>
         

        <input  class="btn btn-success" type="button" value=" 修改选中行 " onclick="Update()">
        
          
        <!--显示数据-->       
        <%
        ArrayList<nation_data> ndlist = null;
        ndlist = (ArrayList<nation_data>) session.getAttribute("nation_data_list"); 
        if(ndlist!=null&&ndlist.size()!=0){%>   
    
        <div class="table-responsive" >  
            <table  border="0" cellspacing="0" cellpadding="0" class="table" id="myTable">  

                <tr class="label-primary"  >  
                    <th scope="col" width="6%"><span style="color:white">选中</span></th> 
                    <th scope="col" width="13%" ><span style="color:white">民族</span></th>  
                    <th scope="col" width="21%"><span style="color:white">男性人口数</span></th>
                    <th scope="col" width="13%"><span style="color:white">男性人口比重(%)</span></th>  
                    <th scope="col" width="21%"><span style="color:white">女性人口数</span></th>  
                    <th scope="col" width="13%"><span style="color:white">女性人口比重(%)</span></th>  
                    <th scope="col" width="13%"><span style="color:white">男女性别比(%)</span></th> 
                </tr> 
                
                <%  
                    for(int i=0;i<ndlist.size();i++){ 
                %>
                    <tr class="active">
                        <td><input  type="checkbox" name = "checkRow"></td>
                        <td ><%=ndlist.get(i).getNation() %></td>  
                        <td><%=ndlist.get(i).getMale_Population()%></td> 
                        <td><%=ndlist.get(i).getMale_Proportion()%></td>
                        <td><%=ndlist.get(i).getFemale_Population()%></td> 
                        <td><%=ndlist.get(i).getFemale_Proportion()%></td>  
                        <td><%=ndlist.get(i).getSex_ratio()%></td>
                    </tr>        
                <%} }%>
            </table>  
        </div>
    </div>    


            
            
                
</body>
