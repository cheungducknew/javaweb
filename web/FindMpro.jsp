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
        <br><br><br><br><br>
        
    <form role="form" name="form1" action="${pageContext.request.contextPath }/FindServlet" method = "get">  
        
        <!-- 输入框1-->
        <div class="form-group">  
            <h2 style="font-size:30px;">请输入您要查询的男性人口比重(%)</h2>
            
            <!--函数功能的input，hidden掉了-->
            <input name="func" type="hidden" value="show" ><br/>
            <!--用于标记本网页为FindNation的input-->
            <input id="catagory" name="catagory" value="男性人口比重(%)" type="hidden">
            
            <div class="input-group">  
                <input type="text" class="form-control" id="data" name="data" 
                       placeholder="输入数据，例如：51.2" >${errerMsg}  
                <span class="input-group-btn">  
                    <button class="btn btn-default" type="button" onClick="form1.submit();" >查询</button>  
                </span>  
            </div>  
        </div>    
           
                           
    </form>                        
              
                
        <%
        nation_data nd= null;
        nd = (nation_data) session.getAttribute("nation_data"); 
        if(nd!=null){%>   
    
        <div class="table-responsive" >  
            <table  border="0" cellspacing="0" cellpadding="0" class="table" >  

                <tr class="label-primary"  >  
                    <th scope="col" width="50%" ><span style="color:white">类别</span></th>  
                    <th scope="col"><span style="color:white">数据</span></th>  
                </tr>  
                <tr class="active">  
                    <td>民族</td>  
                    <td><%=nd.getNation() %></td>  
                </tr>  
                <tr class="success">  
                    <td>男性人口数</td>  
                    <td><%=nd.getMale_Population()%></td>  
                </tr>  
                <tr class="active">  
                    <td>男性人口比重(%)</td>  
                    <td><%=nd.getMale_Proportion()%></td>  
                </tr>  
                <tr class="success">  
                    <td>女性人口数</td>  
                    <td><%=nd.getFemale_Population()%></td>  
                </tr> 
                <tr class="active">  
                    <td>女性人口比重(%)</td>  
                    <td><%=nd.getFemale_Proportion()%></td>  
                </tr>   
                <tr class="success">  
                    <td>男女性别比(%)</td>  
                    <td><%=nd.getSex_ratio()%></td>  
                </tr>        

                <% }else{ %>

                    <div class="alert alert-danger alert-dismissable">  
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>  
                        <strong>对不起!</strong> 没有查到数据，请检查输入数据后，再次查询  
                    </div>   

                <% } %>

            </table>  
        </div>
    </div>    
           
                
</body>
