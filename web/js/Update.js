function Update(){
        var nation = prompt("民族：","输入数据，例如：汉族");
        var male_Population = prompt("男性人口数:","输入数据，例如：625032848");
        var male_Proportion = prompt("男性人口比重(%):","输入数据，例如：51.2");
        var female_Population = prompt("女性人口数:","输入数据，例如：595811672");
        var female_Proportion = prompt("女性人口比重(%):","输入数据，例如：48.8");
        var sex_ratio = prompt("男女性别比(%):","输入数据，例如：104.9");

        var checkboxs=document.getElementsByName("checkRow");
	if(confirm("确认修改选中行?")){
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked){
                                var data = "&nation="+nation+"&male_Population="+male_Population+"&male_Proportion="+male_Proportion+"&female_Population="+female_Population+"&female_Proportion="+female_Proportion+"&sex_ratio="+sex_ratio;
                                window.location.href="UpdateServlet?id="+i+"&func=update"+data;
			}
		}	
	}
}
