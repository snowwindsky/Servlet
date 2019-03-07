<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">

<title>学生信息输入</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function validate() {
		var id = document.forms[0].id.value;
		var name = document.forms[0].name.value;
		var age = document.forms[0].age.value;
		var major = document.forms[0].s_class.value;
		if (id <= 0) {
			alert("学号不能为空，请输入学号！");
			return false;
		} else if (name.length <= 0) {
			alert("姓名不能为空，请输入姓名！");
			return false;
		} else if (age <= 0) {
			alert("请输入合法年龄！");
			return false;
		} else if (s_class.length <= 0) {
			alert("班级不能为空，请输入所在班级！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<br>
	<center>
		<h2>学生信息输入</h2>
		<hr>
		<form action="AddServlet" method="post" id="form"
			onSubmit="return validate()">
			<h4>
				学号：<input type="text" name="id" class="{required:true}"
					title="学号必须为数字"></input><br>
			</h4>
			<h4>
				姓名：<input type="text" name="name" title="姓名不能为空"></input><br>
			</h4>
			<h4>
				年龄：<input type="text" name="age" title="年龄必须为数字"></input><br>
			</h4>
			<h4>
				班级：<input type="text" name="s_class" title="班级不能为空"></input><br>
			</h4>
			<input type="submit" value="提交" />
		</form>
		<!--  <br> <a href="SelServlet?id=<%=""%>">查询学生信息</a>-->
		<a href=toSelect.jsp>返回信息查询页面</a>
	</center>
	     
			
		
</body>
</html>
