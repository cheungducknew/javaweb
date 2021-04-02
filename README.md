 # 使用
 使用 `JavaWeb.sql` 导入MySQL数据，导入项目到  `NetBeans IDE 8.1` （也可以用eclipse或IDEA试试）
 
 ps.项目说明也可以通过javadoc生成




# 技术栈

1. 前端基础：HTML（JSP）+CSS+JS
2. 前端框架：Bootstrap+jQuery
3. 后端：servlet
4. 数据库：MySQL
5. 编程语言：Java
6. MVC设计模式
7. 每个都只需要懂一点点





# **项目目录结构**

1. src文件夹下存放后端控制文件
   1. Controller（控制器）包下存放的是负责转发请求，对请求进行处理的Servlet类。其中有FindServlet.java(查询数据)、InsertServlet.java(添加数据)、RemoveServlet.java(删除数据)、UpdateServlet.java(修改数据)、LoginServlet.java(登陆和判断身份)、StatisticsServlet（数据统计）。
   2. Dao（数据访问）包下存放的是负责进行数据库访问的类。其中有Nation_dataDao (民族数据)、UserDao(用户信息)。
   3. Model（模型）包下存放的是实体类。其中包括nation_data (民族数据)、user(用户信息)。
   4. Util（多用途）包下存放的是工具类。其中包括JDBCUtil.java(数据连接)。

 

2.  web文件夹下存放前端显示文件
    1. image包下存放页面背景照片和404图片
    2. css包下存放页面样式CSS文件
    3. js包下存放JavaScript脚本
    4. jsp页面
    5. WEB-INF包下存放web.xml配置文件以及lib里的jar包



# 功能

> 本系统将用户群体分为管理员与普通用户（查询者）两类，提过数据库的identity进行辨认。
>
> 为管理员提供的功能有添加数据、修改数据、删除数据与查询数据、数据统计功能；为普通用户只提供查询数据和数据统计功能。其中查询功能又可细分为按民族名称查询、按男性人口数查询、按男性人口比重查询、按女性人口数查询、按女性人口比重查询、按男女性别比查询。
>
> 统计功能包含合计功能



# 页面流程

> 本系统默认进入动画页面（Home.jsp）,动画结束后自动跳转至索引页（index.jsp）。由索引页通过点击按钮，可分别进入登陆页(Login.jsp)与404页面。登陆页面实现登陆与身份识别功能。根据身份的不同，分别进入管理员页面与普通用户页面。
>
> 在管理员页面，可通过左侧导航栏分别进入欢迎页（welcome.jsp）、查询页（6页）、添加页(Insert.jsp)、修改页(Update.jsp)、删除页(Remove.jsp)、数据统计页(statistics.jsp)等内嵌页面，也可通过在左上角点击回到首页（index.jsp）。
>
> 在普通用户页面，可通过左侧导航栏分别进入欢迎页（welcome.jsp）、查询页（6页）、数据统计页(statistics.jsp)等内嵌页面，也可通过在左上角点击回到首页（index.jsp）以及左侧导航栏处点击返回登陆页（Login.jsp）。



# **对象和类设计**

因为本项目总体设计采用MVC模式，所以将相关类进行了分类和封装，具体如下所示：

1. 实体（entity）类：nation_data、user。主要负责实例数据的读取(get)以及存储(set)

2. 工具（Util）类：JDBCUtils。主要负责数据库的连接。当数据库发生变化时，只需更改url, Name, password即可。

3. 数据库操作（Dao）类：Nation_dataDao、UserDao。主要负责对数据库进行增删改查操作并返回数据。

4. 业务控制（Controller）类：FindServlet、InsertServlet、LoginServlet、RemoveServlet、StatisticsServlet、UpdateServlet。主要负责业务逻辑的控制。当jsp页面发送请求时，负责处理请求并返回结果。





# 参考

1. [W3 school HTML/CSS]( https://www.w3school.com.cn/h.asp)

2. [菜鸟教程 jQuery](https://www.runoob.com/jquery/jquery-tutorial.html)
3. [How 2J BootStrap](https://how2j.cn/k/boostrap/boostrap-tutorial/538.html)
4. [菜鸟教程 MVC模式](https://www.runoob.com/design-pattern/mvc-pattern.html)

5. [Bootstrap-select中文网](https://www.bootstrapselect.cn/)



