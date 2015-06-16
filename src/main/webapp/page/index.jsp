<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% String rootPath = "http://localhost:8080/apollo-app-svc"; %>
<html>
    <head>
        <title>显示用户信息</title>
        <script type="text/javascript" src="<%=rootPath%>/res/extjs/adapter/ext/ext-base.js"></script>
		<script type="text/javascript" src="<%=rootPath%>/res/extjs/ext-all.js"></script>
		<script type="text/javascript" src="<%=rootPath%>/res/extjs/adapter/ext/ext-basex.js"></script>
		<script type="text/javascript" src="<%=rootPath%>/res/extjs/ext-lang-zh_CN.js"></script>
		<!-- jQuery库 -->
		<script type="text/javascript" src="<%=rootPath%>/res/jquery/jquery-1.6.4.min.js"></script>
		<script type="text/javascript" src="<%=rootPath%>/res/jquery/plugins/jquery.tmpl.min.js"></script>
        <script type="text/javascript">
        	var rootPath = "<%=rootPath %>";
        	
        </script>
		
        <script src="<%=rootPath%>/page/index.js" type="text/javascript"></script>
        
        <style type="text/css">
            table,td{
                border: 1px solid;
                border-collapse: collapse;
            }
        </style>
    </head>
    <body>
    	<div>显示后台返回的值:</div>
        <span id='test_span'>........</span>
    </body>
</html>