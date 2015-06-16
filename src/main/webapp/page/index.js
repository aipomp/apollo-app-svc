//actionURL
var actionQuery = rootPath + "/demo/test";


Ext.onReady(function(){ 
	$.ajax({
		url : actionQuery + "/getCompDesc",
		method:"GET",
		data:{
			
		},
		cache:false,
		async:false,
		success:function(response){
			if(response!=null&&response!="[]"){
				$("#test_span").html(response);
				alert($("#test_span").html())
			}
		},
		error:function(response){
			error();
		}
	});
	
});