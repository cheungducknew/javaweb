<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" import="Model.nation_data"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>民族信息管理系统</title>
</head>
<body style=" background: url(image/bg_index.png)  center fixed; background-size: single;">

    
    <!-- 使用bootstrap框架-->
    <!-- jquery.min.js first, then bootstrap.min.css, then bootstrap.min.js -->
    <script src="js/jquery.min.js"></script>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/bootstrap.min.js"></script>
    
    
    <div >
      <div class="container" align="center" >
           <br> <br> <br> <br> <br> <br> <br> <br>
          <h2 class="text-info" style="font-family:宋体;font-weight:bold;font-size:60px;">民族信息管理系统</h2>
          <br>
          <div class="text-muted" style="font-size:30px; " >欢迎您的光临</div>
          <br>
          <br>
          <p><a role="button" href="${pageContext.request.contextPath }/Login.jsp" class="btn btn-success">点击进入登陆页面</a></p>
      </div>
    </div>
      
      
    <p style="text-align: center;"><a role="button" href="${pageContext.request.contextPath }/404.html" class="btn btn-info">404页面测试</a></p>  
    
    <!-- 底部页脚部分 -->
    <div class="footer">
        <p class="text-center">
            2020 &copy; ducknew
        </p>
    </div>

  
    
<script src="https://cdn.jsdelivr.net/gh/wallleap/cdn/js/sakura.js"></script>
  
</body>
</html>