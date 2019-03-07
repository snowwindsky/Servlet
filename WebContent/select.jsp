<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import="java.util.*"%>
<%@ page import="domain.Student"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>学号查询</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<br>
	<h3>符合条件的学生信息</h3>
	<hr>
	<br>
	<table width="450" border="100" cellSpacing=1
		style="font-size: 15pt; border: dashed 1pt">
		<tr>
			<td>学号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>专业</td>
		</tr>
		<%
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			ArrayList<Student> result = new ArrayList<Student>();
			result = (ArrayList<Student>) request.getAttribute("result");
			if (!result.isEmpty()) {
				for (int i = 0; i < result.size(); i++) {
					Student st = result.get(i);
					out.print("<tr>");
					out.print("<td>" + st.getId() + "</td>");
					out.print("<td>" + st.getName() + "</td>");
					out.print("<td>" + st.getAge() + "</td>");
					out.print("<td>" + st.getS_class() + "</td>");
		%>
		<tr>
			<td><a href="DelServlet?id=<%=st.getId()%>">删除</a></td>
			<td><a href="ToUpdateServlet?id=<%=st.getId()%>">修改</a></td>
		</tr>
		<%
			out.print("</tr>");
				}
			}
		%>
	</table>
	<br>
	<br>
	  <h3>
		<a href=toSelect.jsp>返回信息查询页面</a>
	</h3>
	

</body>
</html>