<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>C:out demo</title>
</head>
<body>
	<c:out value ="${10 + 9 }"/>
	<c:set var="testScore" value="${80}" scope="session"/>
	<c:out value="${testScore}"/><br/>
	
	<c:if test="${testScore >= 80 }">
		<p>Your Score is Awesome: <c:out value="${testScore }"/> </p>
	</c:if>
	
	<c:choose><%-- parecido com if elseif ou switch --%>
		<c:when test="${testScore >=80}">
			A Case
		</c:when>
		
		<c:when test="${testScore >= 60 && testScore <=80}">
			B Case
		</c:when>
		
		<c:otherwise>
			C Default Case
		</c:otherwise>
		
	</c:choose><br/>
	
	
	<%
		List<String> studentNames = new ArrayList<>();
		studentNames.add("Jhon");
		studentNames.add("Nelson");
		studentNames.add("Bharath");
		
		request.setAttribute("studentNames", studentNames);
	%>
	
	<c:forEach var="studentNames" items="{studentNames}">
	
		<c:out value="${studentNames}"/>
	</c:forEach>
	
	<c:forEach var="i" begin="1" end="3">
		<c:out value="${i}"/>
	</c:forEach>
	
	
	<h6>after removal the value is<c:remove var="testScore"/></h6>
	
	
	<c:set var="accountBalance" value="123.456"/>
	
	<fmt:parseNumber var="i" type="number" value="${accontBalance}" />
	<p>Amoount is: <c:out value="${i}"/></p>
	
	
	<c:set var="accountBalance" value="7777.4567"/>
	
	<p>Formated Number 1: <fmt:formatNumber value="${accountBalance}" type="currency"/></p>
	<p>Formated Number 2: <fmt:formatNumber value="${accountBalance}" type="number" maxFractionDigits="2"/></p>
	<p>Formated Number 3: <fmt:formatNumber value="${accountBalance}" type="number" maxIntegerDigits="2" /></p>
	<p>Formated Number 4: <fmt:formatNumber value="${accountBalance}" type="percent"/></p>
	<p>Formated Number 5: <fmt:formatNumber value="${accountBalance}" type="number" pattern="####.##$"/></p>
	
	<br/>

<c:set var="myDate" value ="12-07-2019"/>

<fmt:parseDate var="parseDate" value="${mydate}" pattern="dd-mm-yyyy"/>
<p>Parsed Date: <c:out value="${parseDate}"/></p>
</body>
</html>