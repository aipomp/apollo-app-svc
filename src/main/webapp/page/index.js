//actionURL
var actionQuery = rootPath + "/demo/test";


Ext.onReady(function(){ 
	$.ajax({
		url : actionQuery + "/getCompDesc",
		type : "POST",
		data:{
			compInstId : 1000004,
			name : "中文参数"
		},
		cache:false,
		async:false,
		success:function(response){
			if(response!=null&&response!="[]"){
				$("#test_span").html(response);
			}
		},
		error:function(response){
			error();
		}
	});
	
});