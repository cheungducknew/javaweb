function go(){
    var options=$("#select option:selected"); //jQuery，获取选中的项
    var func = options.val();
    if(func == "未开发模块") alert("功能还没开发。。");
    if(func == "合计") window.location.href="StatisticsServlet?func="+func;
    
}









