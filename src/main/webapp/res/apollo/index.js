/*
 * index.js 框架交互js
 * author gaomy
 */
$(function() {
	var $conts=$(document);
	$conts.delegate(".nav-blk-list","mouseover",function() {
		$(this).siblings(".nav-blk-list").find(".mask01").show();
		$(".mask01").height("385px");
	});
	$conts.delegate(".nav-blk-list","mouseleave",function() {
		$(".mask01").hide();
	});

	//活跃用户切换
//	$(".act-jt-num").eq(0).show();
//	$(".act-show-tm span").eq(0).show();
//	$conts.delegate(".a-act-tab li","hover",function() {
//		$(this).addClass("a-act-over").siblings().removeClass("a-act-over");
//	}, function() {
//		$(this).removeClass("a-act-over");
//	});
//	$conts.delegate(".a-act-tab li","click",function() {
//		var idx = $(this).index();
//		$(".act-show-tm span").eq(idx).show().siblings().hide();
//		$(this).addClass("a-act-vst").siblings().removeClass("a-act-vst");
//		$(".act-jt-num").eq(idx).show().siblings(".act-jt-num").hide();
//	});
	

	// 窗体变小时左右的主体距两边的间距

	function setIframe() {
		var winW = $(window).width();
		if (winW <= 1024) {
			$(".cont,.container").css({"margin": "0 0"});
			$("#indexiframe").css({"width": "950px"});
		}
		else {
			$(".cont,.container").css({"margin": "0 50px"});
			$("#indexiframe").css({"width": ""});
		}
	};
	setIframe();
	$(window).resize(function() {
		setIframe();
	});

	//左侧菜单栏操作
	$conts.delegate("#sub-navlist li","mouseover",function() {
		var idx = $(this).index();
		if ($(this).hasClass("s")) {
			$(".arrow-r").remove();
			$(this).append('<i class="arrow-r">◆</i>');
		}
		$("#sub-navlist li").css({"text-indent": ""}).children("a").removeClass("over");
		$(this).css({"text-indent": "0"}).children("a").addClass("over");
		$(".ej-menu").hide();
		$(".ej-menu" + idx).show();
		$(".ej").children(".ej-item").removeClass("on");
		$(".sj-menu").hide();

	});
	$(".sub-nav").mouseleave(function() {
		$("#sub-navlist li").css({"text-indent": ""}).children("a").removeClass("over");
		$(".ej-menu").fadeOut(500);
		$(".sj-menu").fadeOut(500);
		$(".ej-item").removeClass("on");
	});

	//三级菜单
	$conts.delegate(".ej","mouseover",function() {
		$(".ej").children(".sj-menu").hide();
		$(".ej").children(".ej-item").removeClass("on");
		$(this).children(".sj-menu").show();
		$(this).children(".ej-item").addClass("on");

	});
	$conts.delegate(".ej-menu","mouseover",function() {
		$(this).stop().animate({opacity:1},200);
	});
	


});
//首页导航模块的自适应宽度，首页导航模块的宽度计算(左右间距50px)
function navBlockWd(obj1, obj2) {
	var docW = $("body").width(),
		objW = (docW - 190) / 3;
	if (docW <= 1024) {
		$(obj1).css({"width": "305px"});
		$(obj2).css({"width": "910px"});

	} else {
		$(obj1).css({"width": objW});
		$(obj2).css({"width": docW - 190});
	}
};
//navBlockWd(".nav-blk-list", ".nav-block");
$(window).resize(function() {
	navBlockWd(".nav-blk-list", ".nav-block");
});
//遮罩的高度
function setDaskHeight() {
	if($("#indexiframe").length){
		var parentHg = parseInt($("#indexiframe").height()) + 300;
		$(".shadowBg").height(parentHg);
		if(parentHg<=$(document).height()){
			$(".shadowBg").height($(document).height());
		}
	}
	else{
		$(".shadowBg").height($(document).height());
	}
};

//设置弹窗的高度
function setIframeHeight(obj) {
	var iframe=$("#"+obj);
	try {
		
		if(iframe.contents().find(".asideR-cont")[0]){
			var cntHeight = iframe.contents().find(".asideR-cont")[0].scrollHeight;
			iframe.height(cntHeight+"px");
		}
		if(iframe.contents().find(".outer-box")[0]){
			var cntHeight = iframe.contents().find(".outer-box")[0].scrollHeight+35;
			iframe.height(cntHeight+"px");
		}
		else{
			try {
				var iframe = document.getElementById(obj);
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				//iframe.height = height;
				iframe.style.height=height+"px";
				

			} catch (e) {}	
		}
	} catch (e) {}
};
window.setInterval("setIframeHeight('indexiframe')", 200);
window.setInterval("setIframeHeight('popIframe')", 200);


function getIfrData(data){
	var ifr_el = window.document.getElementById("indexiframe");
	ifr_el.style.height = data+"px";
};

//设置弹窗的宽度

function setPopWidth() {
	var iframe = $("#popIframe");
	iframe.css("width", $("#popIframe").contents().find(".outer-box").width() + 2);

};
//设置弹窗的位置

function setPopPos() {
	var iframe = $("#popIframe"),
		width = iframe.contents().find(".outer-box").width(),
		height = iframe.contents().find(".outer-box").height();
	var topH = ($(window).height() - height) / 2 + $(window).scrollTop();
	var leftW = ($(window).width() - width) / 2;
	if (topH < 0) {
		iframe.css({"top": "5px","left": leftW + "px"});
	} else {
		iframe.animate({"top": topH + "px"},150).css({"left": leftW + "px"});
	}
};