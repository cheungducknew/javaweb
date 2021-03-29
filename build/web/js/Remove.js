function RemoveRow(){
	//var mt=document.getElementById("myTable");
        var checkboxs=document.getElementsByName("checkRow");
	if(confirm("确认删除所选中行数据?")){
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked){
				//var n=checkboxs[i].parentNode.parentNode;//父父节点
				//mt.removeChild(n);
                                //
                                window.location.href="RemoveServlet?id="+i+"&func=remove";
			}
		}	
	}
}
