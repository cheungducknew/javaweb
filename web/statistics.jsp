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
    <!--使用bootstrap-select-->
    <link href="css/bootstrap-select.min.css" rel="stylesheet" />
    <script src="js/bootstrap-select.min.js"></script>
    
    <!--使用自己的js-->
    <script src="js/statistics.js"></script>
    
    <div class="container" >
        <br><br><br><br><br>
         
        
        <div class="form-group">  
            <h2 style="font-size:30px;">请选择您要使用的功能</h2>
            <select  id="select" class ="selectpicker" data-style="btn-info" data-live-search="true" title="功能">
            <option>合计</option> 
            <option>未开发模块</option>
            </select>
            
            <button class="btn btn-success" type="button" onClick="go();" >查询</button>  
        </div>    
           
                                             
              
                
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
