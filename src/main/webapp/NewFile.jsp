<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>it is a jsp</title>
</head>
<body>
	<%! int a=101;
		int b=125;
		int [] arr={1,2,3,4,5};
	%> 
	<%=a %>
	<br>
	<%
	 for(int a:arr)
	 {
		 %>
		 <%=a %>
		 
	<%} %> 
	
</body>
</html>