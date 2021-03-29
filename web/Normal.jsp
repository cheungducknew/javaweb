<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.nation_data"%>

<%@page import="java.util.Date,java.lang.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>普通用户页面</title>
    </head>  
    
    <body style=" background: url(image/bg_Normal.png)  center fixed; background-size: single;text-align: center;">
    <!-- 使用bootstrap框架-->
    <!-- jquery.min.js first, then bootstrap.min.css, then bootstrap.min.js -->
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>      
    <!--主要样式控制（因为和Admin几乎一样，直接照搬）-->
    <link href="css/Admin.css" rel="stylesheet">   
        
        <!--顶部导航栏部分-->
    <nav class="navbar navbar-inverse" style="background:rgba(255,255,255);">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" title="Title" href="index.jsp" style= "background:rgba(0,0,0);">回到首页</a>
           </div>
           <div class="collapse navbar-collapse">
               <ul class="nav navbar-nav navbar-right">
                      
                    <!--右上角显示时间-->
                    <% Date date=new Date(); %>    
                    <li role="presentation">
                        <a>上一次登陆时间：<%=date%></a>
                    </li>
                </ul>
           </div>
        </div>      
    </nav>

    <!-- 中间主体内容部分 -->
    <div class="pageContainer">
         <!-- 左侧导航栏 -->
         <div class="pageSidebar" >
             <ul class="nav nav-stacked nav-pills">              
                 <!-- 开始 -->
                 <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown"  target="mainFrame">
                         查询数据<span class="caret"></span>
                     </a>
                     <ul class="dropdown-menu">
                         <li>
                             <a href="FindNation.jsp" target="mainFrame">按民族查询</a>
                         </li>
                         <li>
                             <a href="FindMpop.jsp" target="mainFrame">按男性人口数查询</a>
                         </li>
                         <li>
                             <a href="FindMpro.jsp" target="mainFrame">按男性人口比重(%)查询</a>
                         </li>
                         <li>
                             <a href="FindFpop.jsp" target="mainFrame">按女性人口数查询</a>
                         </li>
                         <li>
                             <a href="FindFpro.jsp" target="mainFrame">按女性人口比重(%)查询</a>
                         </li>
                         <li>
                             <a href="FindSr.jsp" target="mainFrame">按男女性别比(%)查询</a>
                         </li>
                     </ul>
                 </li>
                 <!-- 结束 -->
                 <li role="presentation">
                     <a href="statistics.jsp" target="mainFrame">数据统计</a>
                 </li>                    
                 <li role="presentation">
                     <a href="Login.jsp" >返回登陆界面</a>
                 </li>
             </ul>
         </div>

        <!-- 左侧导航和正文内容的分隔线 -->
        <div class="splitter"></div>
        <!-- 正文内容部分 -->
        <div class="pageContent">
            <!--最最重要的框架部分-->
            <iframe src ="welcome.jsp"  id="mainFrame" name="mainFrame" frameborder="0" scrolling="no" style="min-height:600px;width:100%;height:100%;"></iframe>
        </div>
     </div>
    
        <!-- 底部页脚部分 -->
    <div class="footer">
        <p class="text-center">
            2020 &copy; ducknew
        </p>
    </div>

     <script type="text/javascript">
     $(".nav li").click(function() {
            $(".active").removeClass('active');
            $(this).addClass("active");
        }); 
     </script>
        

    <script src ="js/heart-shaped_click.js"></script>    
    <script src="https://cdn.jsdelivr.net/gh/wallleap/cdn/js/sakura.js"></script>    
    </body> 
</html>


