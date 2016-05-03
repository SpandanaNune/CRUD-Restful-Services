<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Response</title>
</head>
<body>
<%=request.getParameter("status") %> 
<br />
<a href="<%=request.getParameter("location") %>"><%=request.getParameter("location") %></a>
<br />
To choose other operations
<a href="GradeBook.html">Click Here</a>

</body>
</html>