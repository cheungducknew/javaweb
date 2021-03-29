<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.nation_data"%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body style=" background: rgba(255,255,255,0); background-size: single;text-align: center;">
    <!-- 使用bootstrap框架-->
    <!-- jquery.min.js first, then bootstrap.min.css, then bootstrap.min.js -->
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    
    <div class="container" >
        <br>
        <h1> 插入数据操作页面</h1>
        <form role="form" name="form1" action="${pageContext.request.contextPath }/InsertServlet" method = "get">
            <!--函数功能的input，hidden掉了-->
            <input name="func" type="hidden" value="findAll" >
            <button class="btn btn-info" type="button" onClick="form1.submit();" >显示最新数据</button> 
        </form>
        
            
        <button class="btn btn-success" type="button" data-toggle="modal" data-target="#InsertModal" >插入一条数据</button>  <br> 
            
           
        <!--显示数据-->       
        <%
        ArrayList<nation_data> ndlist = null;
        ndlist = (ArrayList<nation_data>) session.getAttribute("nation_data_list"); 
        if(ndlist!=null&&ndlist.size()!=0){%>   
    
        <div class="table-responsive" >  
            <table  border="0" cellspacing="0" cellpadding="0" class="table" >  

                <tr class="label-primary"  >  
                    <th scope="col" width="12.5%" ><span style="color:white">民族</span></th>  
                    <th scope="col" width="25%"><span style="color:white">男性人口数</span></th>
                    <th scope="col" width="12.5%"><span style="color:white">男性人口比重(%)</span></th>  
                    <th scope="col" width="25%"><span style="color:white">女性人口数</span></th>  
                    <th scope="col" width="12.5%"><span style="color:white">女性人口比重(%)</span></th>  
                    <th scope="col" width="12.5%"><span style="color:white">男女性别比(%)</span></th> 
                </tr> 
                
                <% for(int i=0;i<ndlist.size();i++){ %>
                    <tr class="active">
                        <td><%=ndlist.get(i).getNation() %></td>  
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

<form role="form" name="form2" action="${pageContext.request.contextPath }/InsertServlet" method = "get">
<div class="modal fade" id="InsertModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h1 class="modal-title">请输入数据</h1>
        <!--函数功能的input，hidden掉了-->
        <input name="func" type="hidden" value="insert" ><br/>
      </div>
      <div class="modal-body">
            <div class="block">
                <label>民族:</label>
                <input type="text" class="form-control" id="nation" name="nation" placeholder="输入数据，例如：汉族" >${errerMsg}
            </div>
            <div class="block">
                <label>男性人口数:</label>
                <input type="text" class="form-control" id="male_Population" name="male_Population" placeholder="输入数据，例如：625032848" >${errerMsg}
            </div>
            <div class="block">
                <label>男性人口比重(%):</label>
                <input type="text" class="form-control" id="male_Proportion" name="male_Proportion" placeholder="输入数据，例如：51.2" >${errerMsg}
            </div>
            <div class="block">
                <label>女性人口数:</label>
                <input type="text" class="form-control" id="female_Population" name="female_Population" placeholder="输入数据，例如：595811672" >${errerMsg}
            </div>
            <div class="block">
                <label>女性人口比重(%):</label>
                <input type="text" class="form-control" id="female_Proportion" name="female_Proportion" placeholder="输入数据，例如：48.8" >${errerMsg}
            </div>
            <div class="block">
                <label>男女性别比(%):</label>
                <input type="text" class="form-control" id="sex_ratio" name="sex_ratio" placeholder="输入数据，例如：104.9" >${errerMsg}
            </div>            
      </div>
            
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="form2.submit()">保存</button>
      </div>
    </div>
  </div>
</div>
</form>              
                
</body>
