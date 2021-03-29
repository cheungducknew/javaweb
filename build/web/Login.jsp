<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆界面</title>
</head>

<body style=" background: url(image/bg_Login.jpg) no-repeat center center fixed; background-size: 100%;">

<!-- 使用bootstrap框架-->
<!-- jquery.min.js first, then bootstrap.min.css, then bootstrap.min.js -->
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>

<!-- 使用登陆页css-->
<link href="css/Login.css" rel="stylesheet">
    
<div class="container" >
    <div class="col-md-4"></div>
    <div class="col-md-4" style="background-color:#eee;margin-top:200px;background:rgba(255,255,255,0.6);">
        <center>
            <h3>登陆管理系统</h3>
            <p style="color: #333333"> (默认管理员账户为：root ，"123456")</p>
        </center>
        
        <form action="${pageContext.request.contextPath }/LoginServlet" method = "post">
            <div class="form-group">
                <label>用户名:</label>
                <input type="text" name="username" class="form-control" placeholder="Enter username" aria-describedby="basic-addon1">${errerMsg }
            </div>
            <div class="form-group">
                <label>密码:</label>
                <input type="text" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon2">
            </div>
            
            <div class="col-sm-0">
                <label>身份:</label>
                
                <label class="radio-list">

                <input type="radio" name="identity"  value="admin"/>管理员

                <input type="radio" name="identity"  value="normal"/>普通用户
                </label>
            </div>

            
            <div class="form-inline">
                <!--偏移找按钮位置-->
                <div class="col-sm-offset-2 col-sm-5 ">  
                <input type="submit" value="登陆" class="btn btn-success form-control">
                </div>
                <input type="reset" value="重置" class="btn btn-info form-control">  
                
            </div>
        </form>
    </div>
    <div class="col-md-4"></div>
</div>            
            
</body>
</html>