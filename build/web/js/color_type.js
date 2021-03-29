var str="本项目为民族信息管理系统。\n\
网站前端框架采用Bootstrap+jQuery搭建; \n\
后端通过servlet控制业务逻辑;\n\
Dao负责数据库CRUD操作;\n\
JDBCUtils为数据库连接工具类;\n\
nation_data.java与user.java分别为民族数据实体与用户实体;\n\
项目开发选用NetBeans 8.1 作为开发平台 \n\
JDK 版本为1.8，服务器为Tomcat 8.0.27.0  \n\
数据库为MySQL 8.0.11， 数据库客户端为DataGrip 2020.2.2 x64"
var colors=["red","blue","orange","black","grey","#F5F5DC","#6495ED","#7FFFD4","pink","green","purple"];
document.write('<div id="show" style="width:480px;word-wrap:break-word;word-break: normal;margin:auto auto;padding:15% 0;font-size:25px;"></div>');
var s="",i=0,div=document.getElementById("show"),idx;

/***彩色打字函数部分****/
function color_type(){
    idx=parseInt(Math.random()*colors.length);
    s+="<font color="+colors[idx]+">"+str.charAt(i)+"</font>";
    div.innerHTML=s;
    i++;
    if(i==str.length) {
        i=0;
        s="";
    }
    
    setTimeout("color_type()",100);//时间间隔（毫秒）
}
color_type()