<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int result = request.getAttribite("result");
		out.print("<b> The Avarage is :" + result + "</b>");
	%>

</body>
</html>