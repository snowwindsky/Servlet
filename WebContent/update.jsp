<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="domain.Student"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>学生信息修改</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<br>
	<h2>学生信息</h2>
	<hr>
	<br>
	<h3>要修改的学生信息如下</h3>
	<table width="496" border="100" cellSpacing=1
		style="border: 1pt dashed; font-size: 15pt;" height="31">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>班级</td>
		</tr>
		<%
			int id = 0;
			ArrayList<Student> result = new ArrayList<Student>();
			result = (ArrayList<Student>) request.getAttribute("result");
			if (!result.isEmpty()) {
				for (int i = 0; i < result.size(); i++) {
					Student st = result.get(i);
					id = st.getId();
					out.print("<tr>");
					out.print("<td>" + st.getId() + "</td>");
					out.print("<td>" + st.getName() + "</td>");
					out.print("<td>" + st.getAge() + "</td>");
					out.print("<td>" + st.getS_class() + "</td>");
					out.print("</tr>");
				}
			}
		%>
	</table>
	<h3>将学生信息更改为：</h3>
	<form action="UpdServlet" method="post">
		<h4>
			学号：<input type="text" name="id" value="<%=id%>" title="学号不能改变"></input><br>
		</h4>
		<h4>
			姓名：<input type="text" name="name" title="姓名不能为空"></input><br>
		</h4>
		<h4>
			年龄：<input type="text" name="age" title="年龄不能为空"></input><br>
		</h4>
		<h4>
			班级：<input type="text" name="s_class" title="班级不能为空"></input><br>
		</h4>
		<input type="submit" value="修改" />
	</form>
	<br>
	<h3>
		<a href=add.jsp>返回信息输入页面</a> 
		<a href=toSelect.jsp>返回信息查询页面</a>
	</h3>


</body>
</html>