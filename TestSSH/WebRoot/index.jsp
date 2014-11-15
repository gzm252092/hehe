<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <form>
    	<select id="clazz" onchange="change()">
    	</select>
    	<table>
    		<thead>
    			<tr><th>ID</th><th>NAME</th><th>CLASS</th></tr>
    		</thead>
    		<tbody id='students'>
    			
    		</tbody>
    	</table>
    </form>
  </body>
  <script type="text/javascript" src="./js/jquery-1.11.1.min.js">
  </script>
  <script type="text/javascript">
  //{"cv":[{"claid":"clazz01","name":"international class"},{"claid":"clazz02","name":"common class"}]}
  	$(document).ready(function () {		
			$.ajax({
				type:"POST",
				url:"clazz_load.action",
				success:function(obj){
					init(obj.cv);
				}
			});
	});
	
	function init(cv){
		$("#clazz option").remove();
		for(var i =0;i<cv.length;i++){
			var option = "<option id='"+cv[i].claid+"'>"+cv[i].name+"</option>";
			$("#clazz").append(option);
		}
	}
	//{"lsvs":[{"name":"laogan","stuid":"stu01"},{"name":"paoge","stuid":"stu03"}]}
	function change(){
		//alert("hehe");
		var claid = $("#clazz option:selected").attr("id");
		$.ajax({
				type:"POST",
				url:"student_load.action",
				data:"claid="+claid,
				success:function(obj){
					//alert();
					fill(obj.lsvs,claid);
				}
			});
	}
	
	function fill(lsvs,claid){
		$("#students tr").remove();
		//alert(lsvs.length);
		for(var i =0;i<lsvs.length;i++){
			var tr = "<tr><td>"+lsvs[i].stuid+"</td><td>"+lsvs[i].name+"</td><td>"+claid+"</td></tr>";
			$("#students").append(tr);
		}
		$("#students tr:even").css("background-color","#aeaeae");
		$("#students tr:even").css("background-color","#eaeaea");
	}
  </script>
</html>
